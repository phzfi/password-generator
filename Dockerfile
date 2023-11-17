# syntax=docker/dockerfile:experimental
FROM maven:3.9.5-eclipse-temurin-17-alpine as  build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn clean install -DskipTests


FROM openjdk:17-jdk-slim
RUN apt update
RUN apt install apg -y
VOLUME /tmp
COPY --from=build /workspace/app/target/password-generator*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]