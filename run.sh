#!/usr/bin/env bash

REPO_NAME='spring-boot-example'

sudo docker ps | grep $REPO_NAME | awk '{print $1}' | xargs -n 1 sudo docker rm -f

./gradlew clean build

sudo docker build -t alpine/$REPO_NAME .
sudo docker run -p 8080:8080 -d alpine/$REPO_NAME:latest
