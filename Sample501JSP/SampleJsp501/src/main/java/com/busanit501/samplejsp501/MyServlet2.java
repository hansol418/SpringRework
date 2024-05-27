package com.busanit501.samplejsp501;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 웹브라우저에 접근시 , http://localhost:8080/my
@WebServlet(name = "myServlet2" , urlPatterns = "/my2")
public class MyServlet2 extends HttpServlet {
// 웹브라우저 주소 요청(request), 방식 Get -> 서버(톰캣서버, was = 웹서버 + 톰캣 컨테이너 )
  // 서버 -> 웹브라우저에게 답장(response)
  //doGet : 메서드 이름.
  // HttpServletRequest request, HttpServletResponse response : 매개변수 , 받는 변수 , 메서드 정의하는 곳.
  // throws : 예외가 발생하면, IOException , 예외를 던진다.
  // try catch finally 구문으로 처리하는 방법과 동일하다.

  // throw , 강제로 예외를 발생 시키는 예약어.
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

  // HttpServletRequest , 브라우저가 요청시 필요한 정보를 담는 수납도구.
  // HttpServletResponse, 서버가 응답시 보내는 정보를 담는 수납도구.

  // 보내는 정보의 타입을 지정, MIME 타입,
  response.setContentType("text/html");

  // 서버 -> 웹브라우저에 전달하고 싶은 내용을 출력,
  // 자바, 콘솔 출력시, syso -> System.out.println("hello").
  // PrintWriter, 출력 도구.
  PrintWriter out = response.getWriter();
  // 수납도구에 , html 태그를 입력하기.
  out.println("<html><body>");
  out.println("<h1>" + "MyServlet2" + "</h1>");
  out.println("</body></html>");
}
}







