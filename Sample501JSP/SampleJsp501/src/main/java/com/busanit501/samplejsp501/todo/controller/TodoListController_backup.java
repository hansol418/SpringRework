package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController_backup extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 목록 화면으로 전달,
    // 1차, 더미 데이터 10개를 출력해보기.
    // 마치, 클래스명.특정 변수에 접근.메서드 접근.
    // 원래, TodoService todoService = new TodoService();
    // todoService.getList()
    // static 사용하기. 클래스명.메서드명();

    List<TodoDTO> sampleList = TodoService.INSTANCE.getList();
    // 서버가 -> 클라이언트(웹 브라우저)
    // req 라는 수납 도구에서, 임시 더미 리스트를 담기.
    // key : list , value : sampleList
    req.setAttribute("list",sampleList);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
    requestDispatcher.forward(req, resp);
  }
}







