FROM openjdk:21-slim
COPY target/*.jar backend.jar
ENTRYPOINT ["java", "-jar", "/backend.jar"]
EXPOSE 8080