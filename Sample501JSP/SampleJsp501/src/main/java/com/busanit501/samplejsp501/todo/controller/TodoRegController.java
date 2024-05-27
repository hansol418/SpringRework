package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "todoReg", urlPatterns = "/todo/register")
public class TodoRegController extends HttpServlet {

  //주입 , 서비스 인스턴스 , 포함.
  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 세션의 정보 조회 해보기.
    HttpSession session = req.getSession();

    // 조회 해보기.
    // 웹브라우저 -> 서버에 최초로 접근을 하면, 새로운 시스템 쿠키를 만들어주고,
    // 로그인으로 돌려 보내기.
    if(session.isNew()){
      log.info("뉴 JSessionID: 새로운 유저" );
      resp.sendRedirect("/login");
      return;
    }

    // 세션의 로그인 정보를 저장할 공간을 예) loginInfo 라는 공간에
    // 세션에 로그인 정보가 있다면, 성공 로그인 후 -> 리스트
    // 로그인 정보가 없다면, 다시, 로그인 폼 이동.
    // getter
    if(session.getAttribute("loginInfo") == null){
      log.info("로그인 정보가 없는 유저 ");
      resp.sendRedirect("/login");
      return;
    }

    // 정상 로그인.

    //todo 글 입력 폼
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoReg.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // todo 글 입력 처리 하는 로직.
    // TodoDTO 타입을 받아서, 서비스에 전달하는 로직.
    TodoDTO todoDTO = TodoDTO.builder()
        // 화면에서, name : title
        .title(req.getParameter("title"))
        // 화면에서, name : dueDate
        .dueDate(LocalDate.parse(req.getParameter("dueDate")))
        .build();

    // 실제 데이터 입력하기.
    try {
      // todoDTO, 입력받은 내용을 담아서, 서비스에 보내기
      todoService.register2(todoDTO);
      // 리다이렉트, 메인: 리스트
      resp.sendRedirect("/todo/list");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}







