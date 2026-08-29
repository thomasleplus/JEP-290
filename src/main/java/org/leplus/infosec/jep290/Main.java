package org.leplus.infosec.jep290;

import java.io.IOException;

/** Command-line entry point that runs the {@link Demo}. */
public class Main {

  private Main() {
    super();
  }

  public static void main(String[] args) throws ClassNotFoundException, IOException {
    Demo.run();
  }
}
