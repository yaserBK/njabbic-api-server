FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the JAR built locally by Gradle
COPY build/libs/*.jar app.jar

# Expose app port (optional)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
