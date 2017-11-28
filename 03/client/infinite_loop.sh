#!/bin/sh

trap 'exit'  SIGHUP SIGINT SIGTERM

SERVER=`ip a s eth0 | grep -E -o "([0-9]{1,3}[\.]){3}[0-9]{1,3}"`

while sleep 2
do  
	echo Server on $SERVER - thinking
done
