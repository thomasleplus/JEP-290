FROM jboss/wildfly:25.0.0.Final

HEALTHCHECK NONE

ENTRYPOINT []

COPY target/jep290-0.0.1-SNAPSHOT.war $JBOSS_HOME/standalone/deployments/

COPY src/main/docker/jboss/standalone.xml /opt/jboss/wildfly/standalone/configuration/

USER jboss
