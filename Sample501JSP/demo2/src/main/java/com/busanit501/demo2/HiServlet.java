package com.busanit501.demo2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hiServlet", value = "/hi")
public class HiServlet extends HttpServlet {
  private String message;

  //, 서블릿 코드의 생명주기,
  // 실행순서 1
  public void init() {
    message = "Hi World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //
    response.setContentType("text/html");

    // Hello,
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}
