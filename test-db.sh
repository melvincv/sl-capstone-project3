#!/bin/bash
# Run a temp MySQL DB for testing
docker run --name springbootcrudapp-db -p 3306:3306 -e MYSQL_RANDOM_ROOT_PASSWORD=yes -e MYSQL_DATABASE -e MYSQL_USER -e MYSQL_PASSWORD -d mysql:8.0
# Replace db with localhost for testing
cp -av src/main/resources/application.properties src/main/resources/application.properties.bk
sed -i '2s/db/localhost/2' src/main/resources/application.properties
# wait 3 seconds
sleep 3
# Run maven test
mvn test
# Restore the original file
rm -f src/main/resources/application.properties && mv -v src/main/resources/application.properties.bk src/main/resources/application.properties
# Delete the temp container
docker rm -f springbootcrudapp-db