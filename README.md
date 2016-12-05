Spring Boot Example
===================

This project provides an opinionated example of Spring Boot. In addition to
exercising basic features of the framework, it also makes some choices
regarding included libraries.

Requirements
------------

* Java 8
* Gradle 3
* Docker

Features
--------

Some off-the-shelf Spring libraries have been included within this project:

* **Spring Web** for generating RESTful responses.
* **Spring Actuator** to provide runtime health checks. Detailed responses are
unavailable in a production environment without authentication.
* **Spring DevTools** to restart a running server following recompilation. It
is included as a development feature only and is not exported in the
distribution. 
* **Spring Boot Test** for auto-configuration of the application during
testing. It also adds dependencies for **JUnit 4**, **Hamcrest**, and
* **Spring Boot Gradle plugin** for including runtime dependencies in the build
artifact.
**Mockito**. While AssertJ would normally be among that list, it has been
omitted here.

This project replaces the internal Tomcat container with Jetty; the former is
excluded from the build.

Building
--------

If the Gradle wrapper has been generated, the project can be built in the usual
way:

```./gradlew clean build```

If not then Gradle itself is required.

Thanks to the Spring Boot Gradle plugin, the `build` task will create a fat Jar
at `build/libs/mw-spring-boot-example-1.0-SNAPSHOT.jar` that includes the
necessary runtime dependencies.

Deployment
----------

A Docker configuration has been provided layered over Alpine. It exposes the
application on port 8080.

To build a new image, run:

```docker build -t spring-boot/example .```

To run it, use:

```docker run -p 8080:8080 spring-boot/example:latest```
