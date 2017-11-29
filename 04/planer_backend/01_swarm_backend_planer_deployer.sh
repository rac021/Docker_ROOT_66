#!/bin/bash

HOST_PORT='8082'
IMAGE_NAME="backend_planer"
CONTAINER_NAME="backend_planer_service"
REPLICAS="3"
docker service create -d --name $CONTAINER_NAME -p $HOST_PORT:8080 --replicas $REPLICAS $IMAGE_NAME 

echo 
