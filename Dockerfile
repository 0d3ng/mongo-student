FROM openjdk:8-alpine

ADD target/mongo-0.0.1-SNAPSHOT.jar /opt/mongo.jar

RUN bash -c 'touch /opt/mongo.jar'

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo",
"-Djava.security.egd=file:/dev/./urandom","-jar","/opt/mongo.jar"]