FROM amazoncorretto:11-alpine-jdk
MAINTAINER WMG
COPY target/wmg-0.0.1-SNAPSHOT.jar wmg-app.jar  
ENTRYPOINT ["java","-jar","/wmg-app.jar"]          
EXPOSE 8080