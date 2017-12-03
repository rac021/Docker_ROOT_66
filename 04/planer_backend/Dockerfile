
# Stage 0, based on MAVEN - JAVA 8, to build and compile Planer
FROM maven:3.5.0-jdk-8 AS JAVA
COPY plane/ /usr/src/app 
RUN cd /usr/src/app && mvn clean package 

# Stage 1, based on Nginx, to have only the compiled app, 
FROM openjdk:8-jre 
COPY --from=JAVA /usr/src/app/target/planer-root-66-swarm.jar /opt

CMD ["java","-jar","/opt/planer-root-66-swarm.jar"]
