#!/usr/bin/env bash

docker ps | grep spring-boot-example | awk '{print $1}' | xargs -n 1 docker rm -f

./gradlew clean build

docker build -t alpine/spring-boot-example .
docker run -p 8080:8080 -d alpine/spring-boot-example:latest
