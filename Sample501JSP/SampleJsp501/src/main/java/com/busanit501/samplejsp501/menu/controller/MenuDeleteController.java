package com.busanit501.samplejsp501.menu.controller;

import com.busanit501.samplejsp501.menu.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuDelete", urlPatterns = "/menu/delete")
public class MenuDeleteController extends HttpServlet {
  // 처리
  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 삭제 처리하기.
    // 주의사항, post 방식으로 menuNo을 전달시,
    // <input type="hidden" name="menuNo" value="${sample.menuNo}" />
    // 화면에서, 삭제할 menuNo를 받아오는 코드.
    Long menuNo = Long.valueOf(req.getParameter("menuNo"));
    try {
      // 실제로 해당 번호 메뉴 삭제하는 기능.
      menuService.deleteMenu(menuNo);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // 임시 처리했다 치고, 리스트로
    // PRG, Post Redirect Get
    resp.sendRedirect("/menu/list");
  }
}







