FROM openjdk:latest
ADD target/mongo-0.0.1-SNAPSHOT.jar /opt/mongo.jar
RUN bash -c 'touch /opt/mongo.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/mongo.jar"]