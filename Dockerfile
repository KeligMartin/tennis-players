FROM maven:3.9.8-eclipse-temurin-21 AS build

COPY src /app/src

COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -U -Pprod

FROM openjdk:21
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]