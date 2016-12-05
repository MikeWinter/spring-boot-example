FROM alpine:latest

VOLUME /tmp

RUN apk --update add openjdk8-jre

ADD build/libs/mw-spring-boot-example-1.0-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

EXPOSE 8080
