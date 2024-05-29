package com.busanit501.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
  @NotNull
  private Long tno;
  @NotEmpty
  private String title;
  @Future
  private LocalDate dueDate;
  private boolean finished;
  @NotEmpty
  private String writer;


}







