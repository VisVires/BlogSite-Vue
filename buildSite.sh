#!/bin/bash

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
