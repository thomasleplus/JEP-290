package org.leplus.infosec.jep290;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

	public DemoServlet() {
		super();
		try {
			Demo.run();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}