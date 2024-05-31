package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
  // 여기 메서드와, TodoMapper.xml 파일(SQL 문장을 보관, id 이름과, 메서드 이름 동일)
  // 주의하기.
  String getTime();

  void insert(TodoVO todoVO);

//  페이징을 위한 준비물, PageRequestDTO 탑재하기. 페이징 정보를 담기
  // page ,1 , size 10 , skip 할 번호 정보, 페이지의 영향을 받았음.
  List<TodoVO> listAll(PageRequestDTO pageRequestDTO);

  TodoVO getOne(Long tno);

  void delete(Long tno);

  void update(TodoVO todoVO);
  // 전체 갯수 구하는 메서드, 페이징 처리시 필요한 준비물.
  int getCount();
  int getCount2(PageRequestDTO pageRequestDTO);
}


















