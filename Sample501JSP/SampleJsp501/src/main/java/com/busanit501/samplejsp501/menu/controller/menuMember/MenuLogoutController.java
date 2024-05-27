package com.busanit501.samplejsp501.menu.controller.menuMember;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns = "/menuLogout")
public class MenuLogoutController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그 아웃 처리, 세션의 정보를 삭제 하는 것으로 임시 처리.
    log.info("로그아웃 처리함. ");
    HttpSession session = req.getSession();
    // 세션 삭제 메서드 이용.
    session.removeAttribute("loginInfo");
    session.invalidate();

    resp.sendRedirect("/menuLogin");
  }
}







