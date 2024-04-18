FROM eclipse-temurin:21-alpine

HEALTHCHECK NONE

COPY target/jep290-0.0.1-SNAPSHOT.jar /tmp/

COPY src/main/docker/java/logging.properties /tmp/

ARG USER=default

ENV HOME "/home/${USER}"

RUN adduser -D "${USER}"

USER "${USER}"

WORKDIR "${HOME}"

CMD ["java", "-Djava.util.logging.config.file=/tmp/logging.properties", "-Djdk.serialFilter=java.math.**;!*", "-jar", "/tmp/jep290-0.0.1-SNAPSHOT.jar"]
