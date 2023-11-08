# syntax=docker/dockerfile:experimental
FROM openjdk:17-jdk-slim as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests


FROM openjdk:17-jdk-slim
RUN apt update
RUN apt install apg -y
VOLUME /tmp
COPY --from=build /workspace/app/target/password-generator-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
