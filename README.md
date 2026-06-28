# OmniHub

OmniHub is a Kotlin + Spring Boot retail management platform.

## Requirements

- Java 21
- Docker and Docker Compose
- Optional for local development: PostgreSQL 16+

The project includes a Gradle wrapper, so you do not need a global Gradle install.

## Project Setup

### 1. Clone the repository

```bash
git clone git@github.com:kofinder/OmniHub.git
cd OmniHub
```

### 2. Choose how you want to run it

There are two supported ways to run the project:

- Docker Compose, which is the easiest way and matches the default `docker` Spring profile
- Local Gradle execution, which is useful when developing against a local database

## Run with Docker Compose

This is the recommended setup because `src/main/resources/application.yaml` activates the `docker` profile by default.

You can run Docker Compose directly:

```bash
docker compose -f devops/compose/docker-compose.yml up --build
```

Or use the helper scripts in `devops/scripts` from inside that folder:

```bash
cd devops/scripts
./start.sh
```

What this starts:

- PostgreSQL on `localhost:5433`
- The Spring Boot application on `localhost:8080`
- Nginx on `https://localhost` when the proxy container is enabled successfully

To stop the stack:

```bash
docker compose -f devops/compose/docker-compose.yml down
```

If you also want to remove the database volume:

```bash
docker compose -f devops/compose/docker-compose.yml down -v
```

## Helper Scripts

The `devops/scripts` directory contains convenience wrappers for common Docker tasks.

Run them from `devops/scripts`:

```bash
cd devops/scripts
./start.sh
./stop.sh
./build.sh
./restart.sh
./logs.sh
./clean.sh
```

Script behavior:

- `start.sh` starts the Docker stack with `docker compose up --build -d`
- `stop.sh` stops the stack with `docker compose down`
- `build.sh` rebuilds the containers with `docker compose build --no-cache`
- `restart.sh` restarts the running stack with `docker compose restart`
- `logs.sh` tails the stack logs with `docker compose logs -f`
- `clean.sh` removes containers and volumes, then prunes Docker resources

Note:

- `start.sh`, `stop.sh`, and `build.sh` expect to be run from `devops/scripts` because they `cd ../compose`
- `restart.sh`, `logs.sh`, and `clean.sh` run `docker compose` from the current directory, so run them from the compose folder or adjust the working directory first

## Run Locally

Use this when you want to run the app from your machine instead of Docker.

### 1. Start PostgreSQL

Create a PostgreSQL database named `omnihub` and make sure it is reachable on `localhost:5432`.

The `application-dev.yaml` profile expects the following credentials:

- username: `wantana`
- password: `wantana2026!@#`

If your local database uses different credentials, update `src/main/resources/application-dev.yaml` before starting the app.

### 2. Build and run

```bash
./gradlew clean build
./gradlew bootRun --args='--spring.profiles.active=dev'
```

If you prefer a single build output, you can also run the generated WAR:

```bash
./gradlew clean bootWar
java -jar build/libs/*.war --spring.profiles.active=dev
```

## Application URLs

After startup, the app listens on:

- `http://localhost:8080`

## Notes

- Flyway migrations and seed data are enabled in the `docker` and `dev` profiles.
- The project uses Spring Boot, FreeMarker templates, JPA, Flyway, and PostgreSQL.
- If the app fails on startup, first check that PostgreSQL is running and that the active Spring profile matches your environment.



# Postgres Login
- docker exec -it omnihub psql -U postgres -d omnihub