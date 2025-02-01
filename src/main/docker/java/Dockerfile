FROM eclipse-temurin:23.0.2_7-jdk-alpine@sha256:0201d625fb7777efbba99cdfc99805a58f844413f31b39af0b5cd14057d2b666

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

ENV HOME="${USER_HOME}"

USER "${USER_NAME}"

WORKDIR "${HOME}"

CMD ["java", "-Djava.util.logging.config.file=/tmp/logging.properties", "-Djdk.serialFilter=java.math.**;!*", "-jar", "/tmp/jep290-0.0.1-SNAPSHOT.jar"]
