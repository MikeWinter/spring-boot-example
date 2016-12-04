FROM openjdk:8-jre-alpine

VOLUME /tmp
EXPOSE 8080

ADD build/libs/mw-spring-boot-example-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
