#!/bin/bash

# BUILD IMAGE 

  
URL='http://localhost:8082/rest/plane'

HOST_PORT='8081'
SERVICE='Service_Plane'
IMAGE_NAME="ui_planer:prod"
CONTAINER_NAME="ui_planer_service"

echo
echo " --------------------- "
echo " -- BUILDING IMAGE  -- " 
echo " --------------------- "
echo

# docker build --rm -t $IMAGE_NAME --build-arg env=prod .
docker build --rm -t $IMAGE_NAME --build-arg env=prod .

# RUN IMAGE 
echo
echo " ------------------------------ "
echo " -- RUNNING CONTAINER IMAGE  -- " 
echo " ------------------------------ "
echo 

docker run -d --name $CONTAINER_NAME -e URL="$URL" -e SERVICE="$SERVICE" -p $HOST_PORT:80 $IMAGE_NAME

echo
echo " ---------------------------------------------------- "
echo " UI-PLANER started at : http://localhost:$HOST_PORT/  "
echo " ---------------------------------------------------- "
echo 
