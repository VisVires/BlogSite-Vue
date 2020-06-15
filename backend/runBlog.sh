#!/bin/bash

help()
{
   # Display Help
   echo "Run options:"
   echo "u     Root User username"
   echo "p     Root User password"
   echo "m     MongoDb Password"
   echo
   echo "Syntax: runBlog.sh -u username -p password -m mongoPassword"
}

while getopts ":u:p:m:h" opt; do
  case ${opt} in
    h ) help
	      exit 0
      ;;
    u ) userName=$OPTARG
      ;;
    p ) password=$OPTARG
      ;;
    m ) mongoPass=$OPTARG
      ;;
    \? ) echo "Usage: runBlog.sh -u {userName} -p {password} -m {mongoPassword}"
	 exit
      ;;
  esac
done

if [ -z "${mongoPass}" ] ; then
  help
  exit 1
fi

#if [ -z "${userName}" ] || [ -z "${password}" ] || [ -z "${mongoPass}" ] ; then
#	help
#	exit 1
#fi

./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.data.mongodb.password=${mongoPass} --wgeorge.app.root.user=${userName} --wgeorge.app.root.password=${password}"

exit 0
