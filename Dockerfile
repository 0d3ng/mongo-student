FROM openjdk:8-alpine

RUN apk update && apk add bash

ADD target/mongo-0.0.1-SNAPSHOT.jar /opt/app.jar

RUN bash -c 'touch /opt/app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
