package com.busanit501.samplejsp501.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// 기존에 롬복 사용전 -> 사용후 변경.
// 인스턴스 생성시 모양이 빌더 패턴 모양
@Builder
// set/get/toString/equals/hashCode 등 다 포함됨.
@Data
// 인자값이 없는 생성자, 기본생성자
@NoArgsConstructor
// 모든 인자값을 가지는 생성자.
@AllArgsConstructor
public class TodoDTO {
  // 인스턴스 멤버.
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;


}







