package org.leplus.infosec.jep290;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
@WebServlet("/demo")
/**
 * A servlet that triggers {@link Demo#run()} when it is instantiated, so the deserialization demo
 * runs inside a servlet container (e.g. JBoss).
 */
public class DemoServlet extends HttpServlet {

  /** The constructor. */
  public DemoServlet() {
    super();
    try {
      Demo.run();
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }
}
