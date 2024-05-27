package com.busanit501.samplejsp501;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/test")
public class HelloServlet extends HttpServlet {
  private String message;

  public void init() {
    message = "test";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    // Hello
    // 결론, 이런 형식으로 작업을 안하고, 서버에서 직접 그리기보다.
    // 해당 뷰 화면에 데이터를 넘겨서, 그데이터를 이용하는 방식으로 작업.
    // 모델2.

    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}
