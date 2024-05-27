package com.busanit501.samplejsp501.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;

  //기존에는 반자동으로, 우클릭해서 만들었다면, 이제는 롬복의 애너테이션 이용해서
  // 사용하기.

  //기존 인스턴스 사용법 : A a = new A();
  // a.setTitle("제목")
  //a.setTno(100L);
  //a.setDueDate(new LocalDate().now());

  //@Builder 기본 사용법.
  //
  // TodoVO todo = TodoVO.builder()
  //  .멤버의 이름으로 설정한다.
  //  .build();
//
//  TodoVO todo = TodoVO.builder()
//      .tno(100L)
//      .title("제목100")
//      .dueDate(LocalDate.now())
//      .build();
}







