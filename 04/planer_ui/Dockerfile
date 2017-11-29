
# Stage 0, based on Node.js, to build and compile Angular

FROM node:8.6 AS NODE
WORKDIR /app
COPY plane/package.json /app/
RUN npm install
COPY plane/ /app/
ARG env=prod
RUN npm run build --prod --environment $env
# RUN ng build --env=prod --output-path=build/prod/

# Stage 1, based on Nginx, to have only the compiled app, ready for production with Nginx

FROM nginx:1.13
COPY --from=NODE /app/dist/ /usr/share/nginx/html
COPY plane/nginx-custom.conf /etc/nginx/conf.d/default.conf

COPY script_nginx_runner/nginx_runner.sh /etc/nginx_runner.sh

RUN chmod +x /etc/nginx_runner.sh

# RUN ["chmod", "+x", "/etc/nginx_runner.sh"]

ENTRYPOINT ./etc/nginx_runner.sh 

# ENTRYPOINT ["/etc/nginx_runner.sh"]
