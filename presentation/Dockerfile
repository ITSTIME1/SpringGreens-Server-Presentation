# Stage 1: Build presentation-dev
FROM gradle:8.7 AS build


# Create presentation directory
RUN mkdir -p /app/presentation

# Set docker container working directory
WORKDIR /app/presentation

# Verify the directory creation
RUN ls -la /app

# Copy gradle wrapper and build files
COPY gradle /app/presentation/gradle
COPY gradlew /app/presentation/
COPY build.gradle.kts /app/presentation/
COPY settings.gradle.kts /app/presentation/
COPY src /app/presentation/src
RUN ./gradlew bootJar

# Check if the JAR file is created (optional)
RUN ls /app/presentation/build/libs

# Stage 2: Create a minimal runtime image
FROM amazoncorretto:17

# Set working directory
WORKDIR /app/presentation

# Copy the JAR file from the build stage
COPY --from=build /app/presentation/build/libs/*.jar /app/presentation/presentation-dev.jar

# Expose the application port
EXPOSE 9090

# Command to run the application with a specific Spring profile
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app/presentation/presentation-dev.jar"]
