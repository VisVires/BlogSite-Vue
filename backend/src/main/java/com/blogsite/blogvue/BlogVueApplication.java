package com.blogsite.blogvue;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blogsite.blogvue.models.Role;
import com.blogsite.blogvue.models.RoleEnum;
import com.blogsite.blogvue.models.User;
import com.blogsite.blogvue.repository.DegreeRepository;
import com.blogsite.blogvue.repository.JobRepository;
import com.blogsite.blogvue.repository.ProjectRepository;
import com.blogsite.blogvue.repository.QuoteRepository;
import com.blogsite.blogvue.repository.RoleRepository;
import com.blogsite.blogvue.repository.TechBlogRepository;
import com.blogsite.blogvue.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BlogVueApplication implements CommandLineRunner {
	Logger LOG = LoggerFactory.getLogger(BlogVueApplication.class);
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private DegreeRepository degreeRepository;
	@Autowired
	private TechBlogRepository techBlogRepository;
	@Autowired
	private QuoteRepository quoteRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Value("${wgeorge.app.root.user}")
	private String user;
	
	@Value("${wgeorge.app.root.password}")
	private String password;
	
	@Value("${wgeorge.app.set.root.toggle}")
	private Boolean setRoot;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogVueApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception { 
		if (setRoot) {	
			deleteRepos();
			loadRoles();
			loadRootUser();
		}
	}

	public void deleteRepos() {
		jobRepository.deleteAll();
		projectRepository.deleteAll();
		degreeRepository.deleteAll();
		techBlogRepository.deleteAll();
		quoteRepository.deleteAll();
		roleRepository.deleteAll();
		userRepository.deleteAll();
	}
	
	public void loadRoles() {
		roleRepository.save(new Role(RoleEnum.ROLE_USER));
		roleRepository.save(new Role(RoleEnum.ROLE_ADMIN));
	}
	
	public void loadRootUser() {		
		if (!user.contentEquals("username") && !password.contentEquals("password")) {
			if(!userRepository.findAll().isEmpty()) {
				LOG.info(String.format("Error: A root user already exists"));			
			} else {
				// Create new user's account
				User rootUser = new User(user, encoder.encode(password));
				Set<Role> roles = new HashSet<>();
				// add roles
				Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				roles.add(adminRole);
			
				// set roles and save user
				rootUser.setRoles(roles);
				userRepository.save(rootUser);
				LOG.info(String.format("Added new user \"%s\" as root user", user));
			}
		}
	}
}
