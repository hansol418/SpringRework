package com.busanit501.sample501jsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hello2",  urlPatterns = "/hello2")
public class MyServlet extends HttpServlet {



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
    resp.setContentType("text/html");

    // Hello
    PrintWriter out = resp.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + "test, hello2" + "</h1>");
    out.println("<h1>" + "test, hello2" + "</h1>");
    out.println("</body></html>");

    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/hello.jsp");
    dispatcher.forward(req, resp);

  }
}







