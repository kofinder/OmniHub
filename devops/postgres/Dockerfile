FROM postgres:16

ENV POSTGRES_DB=koffeedb
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres

COPY init.sql /docker-entrypoint-initdb.d/