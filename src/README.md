# Source

Maven sources for a security demo of **JEP 290** (JDK serialization filtering).

- `main/java/org/leplus/infosec/jep290/` — the demo: `Main`, `Demo` and
  `DemoServlet` illustrating Java deserialization with and without a serial
  filter.
- `main/docker/java/` and `main/docker/jboss/` — container setups to run the
  demo on a plain JVM and on JBoss (each with its Dockerfile and config).
- `test/java/org/leplus/infosec/jep290/` — JUnit tests.

For educational/security-research use. Build with `./mvnw`.
