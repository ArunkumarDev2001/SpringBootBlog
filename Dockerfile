FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/Spring_Blog_Application-0.0.1-SNAPSHOT.jar Spring_Blog_Application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Spring_Blog_Application.jar"]