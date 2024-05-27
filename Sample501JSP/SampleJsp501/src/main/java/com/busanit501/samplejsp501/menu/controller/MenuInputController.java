package com.busanit501.samplejsp501.menu.controller;

import com.busanit501.samplejsp501.menu.dto.MenuDTO2;
import com.busanit501.samplejsp501.menu.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "MenuInputController", urlPatterns = "/menu/input")
public class MenuInputController extends HttpServlet {
  //주입 , 서비스 인스턴스 , 포함.
  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 기본, 뷰 jsp 파일로 전달하기.
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuInput.jsp");
    requestDispatcher.forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // todo 글 입력 처리 하는 로직.
    // TodoDTO 타입을 받아서, 서비스에 전달하는 로직.
    MenuDTO2 menuDTO2 = MenuDTO2.builder()
        .menuTitle(req.getParameter("menuTitle"))
        .menuRegDate(LocalDate.parse(req.getParameter("menuRegDate")))
        .build();

    // 실제 데이터 입력하기.
    try {
      // todoDTO, 입력받은 내용을 담아서, 서비스에 보내기
      menuService.register2(menuDTO2);
      // 리다이렉트, 메인: 리스트
      resp.sendRedirect("/menu/list");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
  }








