FROM eclipse-temurin:23_37-jdk-alpine@sha256:a0853c6dc4e304f20b737e3fa21dc1b00e688edf2af3fbdf3e5af675c31ab092

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

ENV HOME "${USER_HOME}"

USER "${USER_NAME}"

WORKDIR "${HOME}"

CMD ["java", "-Djava.util.logging.config.file=/tmp/logging.properties", "-Djdk.serialFilter=java.math.**;!*", "-jar", "/tmp/jep290-0.0.1-SNAPSHOT.jar"]
