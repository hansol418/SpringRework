package com.busanit501.samplejsp501.menu.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuVO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate menuRegDate;
}







