FROM jboss/wildfly:22.0.1.Final

COPY target/jep290-0.0.1-SNAPSHOT.jar /tmp/

COPY src/main/docker/java/logging.properties /tmp/

CMD ["java", "-Djava.util.logging.config.file=/tmp/logging.properties", "-Djdk.serialFilter=java.math.**;!*", "-jar", "/tmp/jep290-0.0.1-SNAPSHOT.jar"]
