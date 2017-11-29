#!/bin/bash

# RUN IMAGE 


URL=${URL:-"https://rac021.com"}
SERVICE=${SERVICE:-"SERVICE_21"}

echo
echo "--------------------------- "
echo " URL     : $URL     "
echo " SERVICE : $SERVICE "
echo "----------------------------"
echo 

echo "{ "                             >  "/usr/share/nginx/html/assets/env.json"
echo "\"data\": { "                   >> "/usr/share/nginx/html/assets/env.json"
echo "   \"URL\": \"$URL\", "         >> "/usr/share/nginx/html/assets/env.json"
echo "   \"SERVICE\": \"$SERVICE\" "  >> "/usr/share/nginx/html/assets/env.json"
echo " } "                            >> "/usr/share/nginx/html/assets/env.json"
echo "}"                              >> "/usr/share/nginx/html/assets/env.json"

# ng build --env=prod --output-path=build/prod/
# ng serve --host 0.0.0.0 --port 4201

# service nginx start

nginx -g 'daemon off;'
