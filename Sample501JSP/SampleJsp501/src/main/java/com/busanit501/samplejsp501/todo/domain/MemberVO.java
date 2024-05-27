package com.busanit501.samplejsp501.todo.domain;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
  private String mid;
  private String mpw;
  private String mname;
  private String uuid;
  private boolean autoLogined;
}







