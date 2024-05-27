package com.busanit501.samplejsp501.filter;

import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // 기본 설정,
    // 동작 여부 확인.
    log.info("로그인 필터 동작 여부 확인. ");

    // ServletRequest는 HttpServletRequest 의 상위. -> 다운캐스팅.

    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    // 세션을 이용하기위해서, 도구 필요. 도구 준비.
    HttpSession session = req.getSession();
    // 로그인시, 세션의 임시 공간의 이름 : loginInfo ,
    // 로그인을 해야 -> 세션 생성. -> 필터를 통과해요.
    //
    if (session.getAttribute("loginInfo") != null) {
//      resp.sendRedirect("/login");
      // loginInfo 키가 있다면, 로그인 필터의 doFilter 진행을 계속 하겠다.
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }

    // session 에 loginInfo 키가 없다면,
    // 쿠키를 체크.
    //req.getCookies(), 웹브라우저의 전체 쿠키 목록.
    // "remember-me" , 찾고자 하는 쿠키 이름(키)
    Cookie cookie = findCookie(req.getCookies(), "remember-me");

    // 세션에도 없고, 쿠키도 없다면, 그냥 로그인
    if (cookie == null) {
      resp.sendRedirect("/login");
      return;
    }

    // 쿠키가 존재하는 상황. 쿠키에서 uuid 를 가져오기.
    String uuid = cookie.getValue();

    try {
      // uuid 를 이용해서, 한명의 회원을 조회가능.
      MemberDTO memberDTO = MemberService.INSTANCE.selectUUID(uuid);

      // memberDTO, 회원이 없다면,
      if(memberDTO == null) {
        // 강제로 예외 발생시키키
        throw new Exception("쿠키 값에 해당하는 유저가 없다.");
      }

      // memberDTO, 회원이 있다면,
      // 세션에 저장하기.
      session.setAttribute("loginInfo", memberDTO);
      //
      filterChain.doFilter(servletRequest, servletResponse);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  } // doFilter

  private Cookie findCookie(Cookie[] cookies, String cookieName) {
    // 유효성 체크 1
   if(cookies == null || cookies.length == 0) {
     return null;
   }
   // Optional<Cookie> : 결과의 값이 존재 한다면, 그 값을 사용하고, 없다면 null 반환.
    // Arrays 시스템 클래스,
    // stream : 병렬처리, 중간 처리, 최종 처리.
    // cookies : 전체 쿠키의 목록.
    // filter : 특정조건에 맞는 요소를 반환하는 기능.
    // cookie.getName().equals(cookieName)
    // 모든 쿠키에서 , 하나씩 각각 전부 다꺼내서 다 비교함. 키의 이름: "remember-me"
    // findFirst() : 찾는 것중에서, 최초에 먼저 발견된 쿠키를 반환함.
   Optional<Cookie> result = Arrays.stream(cookies)
       .filter(cookie -> cookie.getName().equals(cookieName)).findFirst();
    // 유효성 체크를 하려고, 나중에 -> 연산자 이용해서 조금더 간단히 표현할 예정.

return result.isPresent() ? result.get() : null;

  } // findCookie 닫는 부분
} // LoginFilter







