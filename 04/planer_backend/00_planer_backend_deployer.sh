#!/bin/bash

HOST_PORT='8082'
SERVICE='SERVICE_PLANE'
IMAGE_NAME="backend_planer"
CONTAINER_NAME="backend_planer_service"

# Building Image 

echo
echo " --------------------- "
echo " -- Building Image  -- " 
echo " --------------------- "
echo

docker build -t $IMAGE_NAME --file Dockerfile .

# Running Container

echo
echo " ------------------------- "
echo " -- Running Container   -- " 
echo " ------------------------- "
echo 

docker run -d --name $CONTAINER_NAME -p $HOST_PORT:8080 $IMAGE_NAME 

CONTAINER_IP=`docker inspect -f "{{ .NetworkSettings.IPAddress }}" $CONTAINER_NAME `

echo
echo " ------------------------------------------------------------------- "
echo " BACKEND-PLANER started  at : http://$CONTAINER_IP:8080/rest/plane   "
echo " BACKEND-PLANER started  at : http://localhost:$HOST_PORT/rest/plane "
echo " ------------------------------------------------------------------- "

echo 
