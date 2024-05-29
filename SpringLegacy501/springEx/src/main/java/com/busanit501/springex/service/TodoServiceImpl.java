package com.busanit501.springex.service;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoMapper todoMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void insert(TodoDTO todoDTO) {

    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.insert(todoVO);
  }
}







