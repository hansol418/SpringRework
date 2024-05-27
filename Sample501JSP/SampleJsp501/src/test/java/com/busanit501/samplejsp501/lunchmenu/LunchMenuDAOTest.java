package com.busanit501.samplejsp501.lunchmenu;

import com.busanit501.samplejsp501.menu.dao.MenuDAO;
import com.busanit501.samplejsp501.menu.domain.MenuVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class LunchMenuDAOTest {
  private MenuDAO menuDAO;

  // 각 단위 테스트가 실행되기전에,, 먼저 실행되는 어노테이션,
  // todoDAO 할당 함.
  @BeforeEach
  public void ready() {
    menuDAO = new MenuDAO();
  }


  @Test
  public void getSelectAll() throws Exception {
    List<MenuVO> samples = menuDAO.selectAll();
    // 기본 출력이고, 전체 출력
    System.out.println("samples : " + samples);
    // 향상된 for, 목록에서 요소를 하나씩 뽑아서 출력함.
    // samples 목록에서, 하나 요소를 꺼내서 vo 에 담고, 그리고 개별 요소 출력하기.
    samples.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );
  }

  @Test
  public void getSelectOne() throws Exception {
    MenuVO sample = menuDAO.selectOne(1L);
    System.out.println("samples : " + sample);

  }

  // 쓰기
  @Test
  public void insert() throws Exception {
    //  글 작성시 , 데이터를 담아둘 임시 모델 VO 만들기.
    MenuVO menuVO = MenuVO.builder()
        .menuTitle("칼국수")
        .menuRegDate(LocalDate.now())
        .build();
    menuDAO.insert(menuVO);

  }

  // 수정
  @Test
  public void update() throws Exception {
    //  글 작성시 , 데이터를 담아둘 임시 모델 VO 만들기.
    MenuVO menuVO = MenuVO.builder()
        .menuNo(11L)
        .menuTitle("칼국수 수정")
        .menuRegDate(LocalDate.now())
        .build();
    menuDAO.update(menuVO);

  }

  // 삭제
  @Test
  public void delete() throws Exception {

    menuDAO.delete(11L);

  }
}







