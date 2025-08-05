FROM eclipse-temurin:24.0.2_12-jdk-alpine@sha256:8fdbcb6bc6b846640cea7058e6eeb56c311fae4efaa506a213789134065c6b90

HEALTHCHECK NONE

ARG USER_NAME=default
ARG USER_HOME=/home/default
ARG USER_ID=1000
ARG USER_GECOS=Default

COPY target/jep290-0.0.1-SNAPSHOT.jar /tmp/

COPY src/main/docker/java/logging.properties /tmp/

RUN adduser \
  --home "${USER_HOME}" \
  --uid "${USER_ID}" \
  --gecos "${USER_GECOS}" \
  --disabled-password \
  "${USER_NAME}"

USER "${USER_NAME}"

ENV HOME="${USER_HOME}"

WORKDIR "${HOME}"

CMD ["java", "-Djava.util.logging.config.file=/tmp/logging.properties", "-Djdk.serialFilter=java.math.**;!*", "-jar", "/tmp/jep290-0.0.1-SNAPSHOT.jar"]
