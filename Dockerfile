FROM amazoncorretto:11-alpine-jdk // de que imagen de java partimos
MAINTAINER WMG // quien es el dueño
COPY target/wmg-0.0.1-SNAPSHOT.jar wmg-app.jar     //va a copiar el empaquetado a github
ENTRYPOINT ["java","-jar","/wmg-app.jar"]          //es la instruccion que se va a ejecutar primero
