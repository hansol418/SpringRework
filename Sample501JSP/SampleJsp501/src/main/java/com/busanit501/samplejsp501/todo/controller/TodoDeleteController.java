package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoDelete", urlPatterns = "/todo/delete")
public class TodoDeleteController extends HttpServlet {
  // 처리
  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 삭제 처리하기.
    Long tno = Long.valueOf(req.getParameter("tno"));
    try {
      todoService.deleteTodo(tno);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // 임시 처리했다 치고, 리스트로
    resp.sendRedirect("/todo/list");
  }
}







