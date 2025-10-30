# JEP-290

Tests of JEP-290

[![Maven](https://github.com/thomasleplus/JEP-290/workflows/Maven/badge.svg)](https://github.com/thomasleplus/JEP-290/actions?query=workflow:"Maven")

## Build

To build this project, run the following command (Mac or Unix):

```shell
./build
```

This will build the Java code and then 2 Docker images:

- `jep290/java`: to test the filtering with a bare Java 8 VM.
- `jep290/jboss`: to test the filtering with in a JBoss WildFly 14 application server running on top of a Java 8 VM.

## Run

The test is configured with the following JDK serial filter: `java.math.\*_;!_`

This means that only classes in the `java.math` package are allowed to
be serialized.

To run the simple Java 17 test, simply do:

```shell
docker run jep290/java
```

You should see the following output:

```text
Jan 1, 1970 0:00:00 AM sun.misc.ObjectInputFilter$Config lambda$static$0
INFO: Creating serialization filter from java.math.**;!*
Jan 1, 1970 0:00:00 AM java.io.ObjectInputStream filterCheck
FINER: ObjectInputFilter ALLOWED: class java.math.BigInteger, array length: -1, nRefs: 1, depth: 1, bytes: 125, ex: n/a
Jan 1, 1970 0:00:00 AM java.io.ObjectInputStream filterCheck
INFO: ObjectInputFilter REJECTED: class java.lang.Number, array length: -1, nRefs: 2, depth: 2, bytes: 156, ex: n/a
Exception in thread "main" java.io.InvalidClassException: filter status: REJECTED
        at java.io.ObjectInputStream.filterCheck(ObjectInputStream.java:1254)
        at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1877)
        at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1750)
        at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1884)
        at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1750)
        at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2041)
        at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1572)
        at java.io.ObjectInputStream.readObject(ObjectInputStream.java:430)
        at org.leplus.infosec.jep290.Demo.run(Demo.java:22)
        at org.leplus.infosec.jep290.Main.main(Main.java:12)
```

Here we can clearly see that the `java.math.BigInteger` class is allowed
to be serialized, but the `java.lang.Number` is being blocked, as it
should be given the filter that we have set.

To run the JBoss test, simply do:

```shell
docker run jep290/jboss
```
