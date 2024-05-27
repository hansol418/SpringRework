package com.busanit501.samplejsp501.connectTest;

import com.busanit501.samplejsp501.todo.dao.MemberDAO;
import com.busanit501.samplejsp501.todo.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MemberDAOTest {
  private MemberDAO memberDAO;

  @BeforeEach
  public void ready() {
    memberDAO = new MemberDAO();
  }

  @Test
  public void getSelectOne() throws Exception {
    MemberVO memberVO = memberDAO.getWithPasswordMember("lsy","1234");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    log.info("memberVO : " + memberVO);

  }

  @Test
  public void insertMember() throws Exception {
    MemberVO memberVO = MemberVO.builder()
        .mid("lsy0523")
        .mpw("1234")
        .mname("이상용0523")
        .build();
   memberDAO.insertMember(memberVO);
 // 디비 콘솔에서 확인하기.

  }

  @Test
  public void updateUUID() throws Exception {
    memberDAO.updateUUID("lsy","testuuid22222222222");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    // 디비 콘솔에서 확인해보기.

  }


  @Test
  public void checkAutoLogin() throws Exception {
   memberDAO.checkAutoLogin("lsy", false);
    // 디비 콘솔에서 확인해보기.

  }

  @Test
  public void selectUUID() throws Exception {
    MemberVO memberVO = memberDAO.selectUUID("d508307d-2f79-4f48-91f7-8a52568e8fbe");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    log.info("memberVO : " + memberVO);
    // 디비 콘솔에서 확인해보기.

  }
}







