package com.busanit501.springex.service;

import com.busanit501.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
  void insert(TodoDTO todoDTO);
  // 맵퍼, listAll 반환 타입 : TodoVO
  // 서비스에서, TodoDTO 로 모두 변환하기.
  List<TodoDTO> listAll();
}













