package com.busanit501.samplejsp501.service;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class ServiceTest {
  //  다른 클래스의 인스턴스가 필요해요. -> 주입, 포함
  private TodoService todoService;

  // 아래에 다른 메서드들이 실행되기전에, 먼저 실행이 됨.(역할, todoService 초기화 해주는 역할)
  @BeforeEach
  public void ready(){
    todoService = TodoService.INSTANCE;
  }

  @Test
  public  void register() throws Exception {
    // TodoService 기능 구현 확인.
    TodoDTO todoDTO = TodoDTO.builder()
        .title("샘플 11")
        .dueDate(LocalDate.now())
        .finished(false)
        .build();

    //Log4j2, log.info("Register")
    log.info("todoDTO : " + todoDTO);

    // 인자 값으로 TodoDTO 를 사용해야함.
    todoService.register2(todoDTO);

  }
}







