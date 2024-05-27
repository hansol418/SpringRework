package com.busanit501.samplejsp501.menu.dto;

import java.time.LocalDate;

public class MenuDTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate dueDate;

  public Long getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(Long menuNo) {
    this.menuNo = menuNo;
  }

  public String getMenuTitle() {
    return menuTitle;
  }

  public void setMenuTitle(String menuTitle) {
    this.menuTitle = menuTitle;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  // MenuDTO menuDTO = new MenuDTO();
  // System.out.println("MenuDTO : " + menuDTO);
  // 해당 인스턴스를 출력시, 밑에 toString 메서드가 동작 합니다.
  @Override
  public String toString() {
    return "MenuDTO{" +
        "menuNo=" + menuNo +
        ", menuTitle='" + menuTitle + '\'' +
        ", dueDate=" + dueDate +
        '}';
  }
}







