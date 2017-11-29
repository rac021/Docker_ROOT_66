#!/bin/bash

HOST_PORT='8082'
IMAGE_NAME="backend_planer"
CONTAINER_NAME="backend_planer_service"

docker service create -d --name $CONTAINER_NAME -p $HOST_PORT:8080 --replicas 3 $IMAGE_NAME

echo 
