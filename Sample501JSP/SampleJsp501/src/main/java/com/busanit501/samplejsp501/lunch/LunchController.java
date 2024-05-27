package com.busanit501.samplejsp501.lunch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Lunch", urlPatterns = "/lunch")
public class LunchController extends HttpServlet {
  // 메뉴 입력을 받는 폼, get
  // 메뉴 로직 처리하는 , post

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("get : 입력 폼으로 받기");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/lunch/lunchInput.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("lunch post 처리 ");
    String menuName = req.getParameter("menuName");
    System.out.println("menuName 확인 :  " + menuName);
    if (menuName.equals("test")){
      resp.sendRedirect("/");
    } else {
      resp.sendRedirect("/lunch");
    }

  }
}







