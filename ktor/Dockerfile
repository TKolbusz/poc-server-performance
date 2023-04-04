# Base image
FROM openjdk:11-jdk-slim

# Set working directory
WORKDIR /app

# Copy build artifacts to container
COPY build/libs/fat.jar /app/app.jar

# Expose port
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "app.jar"]