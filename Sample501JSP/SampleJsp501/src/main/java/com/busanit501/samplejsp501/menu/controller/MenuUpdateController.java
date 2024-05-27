package com.busanit501.samplejsp501.menu.controller;

import com.busanit501.samplejsp501.menu.dto.MenuDTO2;
import com.busanit501.samplejsp501.menu.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "menuUpdate",urlPatterns = "/menu/update")
public class MenuUpdateController extends HttpServlet {
  private MenuService menuService = MenuService.INSTANCE;
  // 폼, 처리도

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      // 수정폼, 해당 게시글 번호에 대해서 수정폼을 열기.
      Long menuNo = Long.valueOf(req.getParameter("menuNo"));
      // tno 번호에 대한 해당 게시글 가져오기.
      MenuDTO2 sample = menuService.getSelectOne(menuNo);
      //
      log.info("MenuListController , 확인2, sample : " + sample);
      // 화면에 전달하기. key : sample , 값 : 0x100
      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/menu/menuUpd.jsp")
          .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //처리
    // 수정, 변경할 데이터를 먼저 가져오기. 콘솔에 찍어보기.
    Long menuNo = Long.valueOf(req.getParameter("menuNo"));
    log.info("menuNo: 수정작업중, 데이터받아서 확인중.1 menuNo : " + menuNo);
    String menuTitle = req.getParameter("menuTitle");
    log.info("menuTitle: 수정작업중, 데이터받아서 확인중.2 menuTitle: " + menuTitle);
    LocalDate localDate = LocalDate.parse(req.getParameter("menuRegDate"));
    log.info("menuRegDate: 수정작업중, 데이터받아서 확인중.3 menuRegDate: " + localDate);

    // 박스에 담기. DTO  담고, -> VO 변환.
    MenuDTO2 menuDTO = MenuDTO2.builder()
        .menuTitle(menuTitle)
        .menuRegDate(localDate)
        .menuNo(menuNo)
        .build();

    // 서비스에 전달하기.
    try {
      menuService.updateMenu(menuDTO);
      resp.sendRedirect("/menu/list");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}







