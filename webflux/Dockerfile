# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy build artifacts to container
COPY build/libs/poc-server-perf-webflux-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "app.jar"]