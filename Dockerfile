# =============================
# 1. Build Stage
# =============================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot JAR
RUN mvn clean package -DskipTests

# =============================
# 2. Run Stage
# =============================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy only the JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 7000

ENTRYPOINT ["java", "-jar", "app.jar"]
