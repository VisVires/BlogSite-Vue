ls.md

What happens when you input ls -l foo* in your bash shell?

* * *

This was an interview question I saw recently for a System Administrator role, and while there are many resources to answer this question, I didn't feel any were complete enough. My hope is to start with a high level overview and gradually make this post get deeper and deeper into the rabbit hole of the ls command.

* * *

### The Parent Shell

<div class="well-sm">`$ls -l foo*`</div>

User writes command into stdin of shell which is waiting with getline() function

Then the bash shell checks if command is an alias and if not it checks if command exists via a script similar to the following, where it uses the bash builtin command "command" to see if the command exists in PATH

<div class="well-sm">`#!/bin/sh  
#$1 holds the requested command  
if command -v $1 &>/dev/null  
then  
`return 1`  
else  
`return 0`  
fi`</div>

The `command` command works by using the `stat()` C function which returns information about a file if it can find it or -1 and an error if not.

The PATH is then tokenized using the ":" to separate each element and each segment in the path is checked to search for the command.

Here's an example of the search from my own PATH:

<div class="well-sm">`stat("/home/username/bin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/home/username/.local/bin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/usr/local/sbin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/usr/local/bin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/usr/sbin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/usr/bin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/sbin/ls", 0x7ffc92ee7d20) = -1 ENOENT (No such file or directory)  
stat("/bin/ls", 0x7ffc92ee7d20) = 0  
`</div>

As you can see the command is found in the /bin folder.

If the command is valid the shell then uses the fork() system call to start allocating resources to handle the new command

### The fork() System Call

When the fork() system call is executed a series of events happen to create a new process:

1.  fork() system call and switches control from user mode to kernel mode by issuing a trap passing control to the interrupt vector 0x80, when int 0x80 is executed the call transfers to the kernel entry point _system_call. This is the same for all system calls and saves all the registers.
2.  The next instruction is the assembly instruction `pushl eax` which pushes a long onto the eax register that represents the actual system call.
3.  Any arguments are sent to the other registers
4.  The kernel executes the system call then returns the result to the user program
5.  With the fork() execution by the kernel an _almost_ exact copy of the parent process is made called the child process with the following events:

*   Child's task structure is allocated
*   Child's task structure is filled from the parent
*   Child's stack and user area's are allocated
*   Child's user area filled from parent
*   A Process ID (PID) is allocated for the child
*   Child is set up to share parent's text
*   Page tables for data and stack are copied

*   Note: Many modern Linux systems give the child page tables but instead of copying them it just has them point to the parent's pages. If the child or parent attemptes to write on the page then a new copy of the page is allocated..this will save memory and is called a **copy on write.**

*   Sharing of open files between child and parent is set up
*   Parents registers are copied from parent to child

This series of steps creates a new shell almost identical to the parent except for:

*   PID
*   Parent's PID
*   It has it's own copy of file descriptors and directory streams
*   Process, text, data and memory locks
*   Process times in the tms struct
*   Resource utilizations for new process set at 0
*   Pending signals initialize to the empty set
*   Timers created not inherited
*   Asynchronous input or output operations are not inherited

### Processing the Command

Once the new child process is created we need to execute the command. which will be done with the `execve()`

The exec commands purpose is to replace the current program with the specified program. In bash there are a couple types of exec commands:

*   `int execl(char *path, char *arg1, ... char* argn)`  
    (uses strings as arguments from 1 to n)
*   `int execv(char *path, char *arg[])`  
    (uses an array of pointers to strings as arguments)

The specific command in this case is:

<div class="well-sm">`execve("/bin/ls", ["ls", "-l", "foo.cpp", "foobar", "fooie"], [/* 68 vars */])`</div>

As you can see the first argument is the path, the second is an array of strings as arguments including the command "ls","-l", "foo.cpp", "foobar",and "fooie", the final argument is the enviroment variables.

As you can see an expansion has occured. The original foo* argument was expanded with the current files in the directory that start with the specified parameter "foo", we'll get into how this happened in a later post.

When the `execv()` is called on the valid command several steps occur to replace the current shell with ls.

1.  First we find the executable program
2.  Verify the executable permissions for the program
3.  The shell reads the header then verifies it
4.  The arguments and enviromental strings are copied to the kernel
5.  The old address space is freed
6.  A new address space is allocated
7.  Arguments and enviromental variables are copied to stack
8.  Signals are reset
9.  Registers are initialized

The ls command is now ready to be executed in its new address space

### The ls Command

`opendir()` used open the current directory or directory listed

Next using either the getdents() system call or readdir() with the current directory as the argument the program moves through each file in the directory

As we move through each item in the directory those that match the arguments in the execv() function are called with fstat(), a variation of stat() which finds the file name and the information for each file in the current working directory for output

Each item that is found is the output to STDOUT (unless redirected) with a write() system call

Finally closedir(3) is used and the user can now see the files that match the arguments in the output