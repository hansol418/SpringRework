package com.busanit501.springex.service;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;
import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

  @Override
//  public List<TodoDTO> listAll(PageRequestDTO pageRequestDTO) {
  public PageResponseDTO<TodoDTO> listAll(PageRequestDTO pageRequestDTO) {
    List<TodoVO> sampleLists = todoMapper.listAll(pageRequestDTO);
    // TodoVo -> TodoDTO
    // 첫번째 재료
   List<TodoDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, TodoDTO.class))
        .collect(Collectors.toList());
   // 두번째 자료, PageRequestDTO, 파라미터꺼 사용. 1차 문제점.
    // 검색 결과에 대한 , page, size , 사용해야 하는데, 요청시 받은 정보를 계속 사용한 점.

    // 세번째 전체 갯수. 2차 문제, 무조건 전체 갯수를 리턴.
    // 해결 : 만들어 두었던, 검색 결과 적용도 되고, 적용 안해도 가능한 메서드 이용.
    int total = todoMapper.getCount2(pageRequestDTO);

     log.info("=========================현재: TodoServiceImpl, pageRequestDTO getPage: 값 확인 :" + pageRequestDTO.getPage());

    //원래는 PageResponseDTO.builder.build() -> 변경됨.
    // PageResponseDTO.<TodoDTO>withAll().build();
    PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
        .pageRequestDTO(pageRequestDTO)
        .dtoList(dtoLists)
        .total(total)
        .build();

    log.info("=========================현재: TodoServiceImpl, pageResponseDTO getPage : 값 확인 :" + pageResponseDTO.getPage());

    return pageResponseDTO;
  }

  @Override
  public TodoDTO getOne(Long tno) {
    TodoVO todoVO = todoMapper.getOne(tno);
    TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
    return todoDTO;
  }

  @Override
  public void delete(Long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void update(TodoDTO todoDTO) {
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.update(todoVO);
  }

  @Override
  public int getCount() {
    int result = todoMapper.getCount();
    return result;
  }

  @Override
  public int getCount2(PageRequestDTO pageRequestDTO) {
    int result = todoMapper.getCount2(pageRequestDTO);
    return result;
  }

}







