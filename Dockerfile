# Dockerfile
FROM ubuntu:latest

RUN apt-get update && apt-get install -y sqlite3 libsqlite3-dev

WORKDIR /db

COPY ./scripts/db/init.sql /db

RUN chmod +x /db/init.sql

CMD ["/db/init.sql"]
