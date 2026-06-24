# ===============================
# Build Stage
# ===============================
FROM gradle:8.14.3-jdk21 AS build

WORKDIR /app

COPY . .

# Build WAR (important: skip tests optional)
RUN gradle clean bootWar -x test

# ===============================
# Runtime Stage
# ===============================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy generated WAR (safe name)
COPY --from=build /app/build/libs/*.war app.war

EXPOSE 8080

# Run WAR as executable Spring Boot application
ENTRYPOINT ["java", "-jar", "app.war"]