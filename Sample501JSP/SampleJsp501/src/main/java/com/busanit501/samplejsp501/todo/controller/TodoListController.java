package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.MemberService;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "todoList", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

  //주입 , 서비스 인스턴스 , 포함.
  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // DB 에서 , 전체 목록을 가져오기.

    // 설정한 세션의 정보 가져오기.
    // 값 문자열 타입.
//    HttpSession session = req.getSession();
//    String loginInfoSession = (String) session.getAttribute("loginInfo");
//    log.info("Login info 세션의 정보 get하기.: " + loginInfoSession);
    // 방법2 , 값 인스턴스
    HttpSession session = req.getSession();
    MemberDTO noAutoLoginmemberDTO = (MemberDTO) session.getAttribute("loginInfo");
    log.info("Login info 세션의 정보 noAutoLoginmemberDTO 하기.: " + noAutoLoginmemberDTO);
    String mid = noAutoLoginmemberDTO.getMid();
    String mpw = noAutoLoginmemberDTO.getMpw();
    MemberDTO memberDTO = null;

    try {
      memberDTO = MemberService.INSTANCE.getOneMember(mid, mpw);
      log.info("memberDTO.: " + memberDTO);
      //todoService.listAll(); -> 디비에서, 전체 목록 가져오기.
      List<TodoDTO> sampleList = todoService.listAll();
//      log.info("TodoListController , 확인2, sampleList : " + sampleList);

      // 컨트롤러에서 (서버)-> 화면(jsp)에 -> 데이터 전달
      req.setAttribute("list", sampleList);
      req.setAttribute("memberDTO", memberDTO);
      req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
          .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}







