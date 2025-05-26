FROM openjdk:21-jdk-alpine
COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "/backend.jar"]
EXPOSE 8080