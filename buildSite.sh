#!/bin/bash

# check if docker is running
if [ "$( docker container inspect -f '{{.State.Running}}' blog-mongo )" == "true" ]; then
	echo "Docker blog-mongo running"
fi

# stop current site
kill -9 `pgrep -f BlogSite`

#pull down updates from git
git pull

# rebuild site
mvn clean install -DskipTests

# move to backend script location
cd "${PWD}"/backend

#redeploy site
./runBlog.sh
