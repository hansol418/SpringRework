package com.busanit501.springex.dto;

import lombok.*;

import java.util.List;

// <E>, 포괄적인 표현
// 예) PageResponseDTO<TodoDTO>
// 예) PageResponseDTO<SearchDTO>
// 예) PageResponseDTO<MemberDTO>
@Getter
@ToString
public class PageResponseDTO<E> {
  private int page;
  private int size;
  private int total;

  //시작 페이지 번호,
  private int start;

  //끝 페이지 번호,
  private int end;

  // 이전 페이지 존재 여부
  private boolean prev;

  // 다음 페이지 존재 여부
  private boolean next;

  // 전달할 페이징이 된 todo 10개 목록.
  private List<E> dtoList;

//  private PageRequestDTO pageRequestDTO;

  //생성자 만들기.
  // builderMethodName = "withAll" -> 기존 빌더 패턴 사용시, TodoVO.builder.build()
  // builder 의 이름이 -> withAll 교체
  // pageRequestDTO : 화면 -> 서버 : 페이징 정보, page, size, getSkip,
  // List<E> dtoList : 10개씩 조회한 Todo 정보들
  // total : Todo의 전체 갯수
  // 결론, PageResponseDTO 에, 파라미터의 정보들이 다 들어있다.
  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();

    this.total = total;
    this.dtoList = dtoList;

    // 추가정보
    // end : 끝페이지 번호,
    // page : 1 ~ 10 -> (int)(Math.ceil(this.page / 10.0)) : 1,
    // end : 10
    this.end = (int)(Math.ceil(this.page / 10.0)) * 10;

    this.start = this.end - 9;

    // 문제, 10페이지 미만인 경우,
    int last = (int)(Math.ceil(total/(double)size));

    // 10 > 8 , end : 8
    // 부트는 Pageable 인터페이스 도구 이용하면, 한방에 됨. 걱정 노노.!!
    this.end = end > last ? last : end;

    this.prev = this.start > 1;
    // total : 125, >100
    // total : 75 > 100
    this.next = total > this.end * this.size;
  }

}







