package com.busanit501.mini_project.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 화면상에서 접근하는 URL 주소를 맵핑 해주는 역할.
// 설정은 , 클래스 앞에도 가능하고, 메서드 앞에도 가능함.
@RequestMapping("/lunchMenu")
@Log4j2
public class LunchMenuController {
  @RequestMapping("/list")
  public  void listTest() {
    // 최종 경로 : http://localhost:8080/todo/list
    // 최종 경로 : /todo/list
    log.info("lunchMenu list 조회 화면 테스트 콘솔");
  }
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registerTest() {
    log.info("lunchMenu register 등록 화면 테스트 콘솔");
  }

}






