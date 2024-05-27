package com.busanit501.samplejsp501.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
  // get : 폼화면을 그려준다.
//  예) 로그인 화면, 계산기 숫자를 입력 받는 폼화면.
// 주의사항, 화면에 절대로 직접 접근 안한다.
  // 컨트롤러 를 거쳐서 간다.
  // 역할 : 화면 페이지로 안내 해주면된다.

  // 반드시, 웹브라우저가 먼저 요청을함. get 방식으로 계산기 입력폼 불러와줘.
  // HttpServletRequest req , 역할 : 브라우저가 요청한 정보가 담아져 있다.
  //  HttpServletResponse resp , 역할 : 서버가 응답시 정보를 담는 상자로 사용함.
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // doGet 재정의해서 사용할려는 의도인데, 이걸 부모꺼 그대로 쓰면, 의도 맞지 않음.
//    super.doGet(req, resp);
    System.out.println("작업순서1 : InputController 거쳐가기. doGet 으로 받기 ");
    // 컨트롤러에서, 해당 입력폼 화면으로 전달하는 코드.
    // 서버에서는, 웹브라우저가 가야할 페이지 정보를 담아 놓았다. 여기에 requestDispatcher
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
    // 역할:, 해당 뷰페이지로 전달하기.
    // 서버 -> 브라우저에게 정보를 제공
    requestDispatcher.forward(req,resp);
  }


  // post : 무언가 로직을 처리한다.
//  예 로그인 처리, 계산기 숫자를 처리하는 로직.

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    super.doPost(req, resp);
    // 재정의, -> calc 처리한 결과 페이지로 가는게 목적.
    System.out.println("작업순서1 : InputController 거쳐가기. doPost 으로 받기 ");
    // 입력 폼에서 넘어온 데이터를 받기. 항상 반환이 문자열 타입이다.
    String num1 = req.getParameter("num1");
    String num2 = req.getParameter("num2");
    // 단순 입력 받은 숫자만 출력해보기.
    System.out.println("num1: " + num1 + " num2: " + num2);

    // 결과 페이지 반환 해보기, 테스트로 index.jsp 로 가보기.
    resp.sendRedirect("/");
  }
}







