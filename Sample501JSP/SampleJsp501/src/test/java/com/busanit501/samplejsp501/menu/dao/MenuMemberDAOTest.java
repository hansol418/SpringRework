package com.busanit501.samplejsp501.menu.dao;

import com.busanit501.samplejsp501.menu.domain.MenuMemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MenuMemberDAOTest {
  private MenuMemberDAO menuMemberDAO;

  @BeforeEach
  public void ready() {
    menuMemberDAO = new MenuMemberDAO();
  }

  @Test
  public void getSelectOne() throws Exception {
    MenuMemberVO menuMemberVO = menuMemberDAO.getWithPasswordMember("lsy","1234");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    log.info("memberVO : " + menuMemberVO);

  }

  @Test
  public void insertMember() throws Exception {
    MenuMemberVO menuMemberVO = MenuMemberVO.builder()
        .mid("lsy0523")
        .mpw("1234")
        .mname("이상용0523")
        .build();
   menuMemberDAO.insertMember(menuMemberVO);
 // 디비 콘솔에서 확인하기.

  }

  @Test
  public void updateUUID() throws Exception {
    menuMemberDAO.updateUUID("lsy","testuuid22222222222");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    // 디비 콘솔에서 확인해보기.

  }
//
//
//  @Test
//  public void checkAutoLogin() throws Exception {
//   memberDAO.checkAutoLogin("lsy", false);
//    // 디비 콘솔에서 확인해보기.
//
//  }
//
  @Test
  public void selectUUID() throws Exception {
    MenuMemberVO menuMemberVO = menuMemberDAO.selectUUID("testuuid22222222222");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    log.info("menuMemberVO : " + menuMemberVO);
    // 디비 콘솔에서 확인해보기.

  }
}







