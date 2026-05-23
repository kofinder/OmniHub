# ===============================
# Build Stage
# ===============================
FROM gradle:8.14.3-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle clean build -x test

# ===============================
# Runtime Stage
# ===============================
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]