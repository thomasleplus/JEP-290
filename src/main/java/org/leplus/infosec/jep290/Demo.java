package org.leplus.infosec.jep290;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public final class Demo {

  private Demo() {
    super();
  }

  /**
   * Runs the demo.
   *
   * @return a string representation of the deserialized object.
   * @throws IOException if an I/O error occurs.
   * @throws ClassNotFoundException if the class of a serialized object cannot be found.
   */
  public static String run() throws IOException, ClassNotFoundException {
    try (final ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
      try (final ObjectOutputStream out = new ObjectOutputStream(bos)) {
        out.writeObject(BigInteger.valueOf(1));
        try (final ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray())) {
          try (final ObjectInputStream in = new ObjectInputStream(bis)) {
            return in.readObject().toString();
          }
        }
      }
    }
  }
}
