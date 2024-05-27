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

@Log4j2
@WebServlet(name = "menuRead", urlPatterns = "/menu/read")
public class MenuReadController extends HttpServlet {

  private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //화면이동 1,
    // 데이터를 불러와서, 화면에 전달.
    // 본인 컨트롤러, 해당 기능이 없어요, 누가 그 기능 가지고 있나요?
    // 서비스를 주입 , 포함.
    // 화면에서, 한개를 클릭시, menuNo를 번호를 , 브라우저 -> 서버 전달.
    // 화면에서, 예) http://localhost:8080/menu/read?menuNo=3
    // ?menuNo=3 , 쿼리스트링, 파라미터, 서버에서 값을 가져오는 코드.
    Long menuNo = Long.valueOf(req.getParameter("menuNo"));
    // 임시로 담아두기 위한 박스, 모델.
    MenuDTO2 sample = null;
    try {
      // 서비스 이용해서, 디비에서 데이터를 가져오는 코드.
      // 예) menuNo=3, 해당하는 제목, 날짜, 번호등 데이터 가지고 왔다.
      sample = menuService.getSelectOne(menuNo);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    log.info("TodoListController , 확인2, sample : " + sample);
    // 화면에 데이터 전달하는 코드.
    req.setAttribute("sample", sample);

    req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp")
        .forward(req, resp);
  }
}







