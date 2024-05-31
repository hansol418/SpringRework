package com.busanit501.springex.service;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;
import com.busanit501.springex.dto.TodoDTO;
import com.busanit501.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private TodoService todoService;


  @Test
  public void testInsert() {
    // 임시 TodoVO , 인스턴스 필요하고,
    TodoDTO todoDTO = TodoDTO.builder()
        .title("돈까스33333333333333333333333333")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용333333333333333333")
        .build();
    todoService.insert(todoDTO);
  }

  // 페이징 정보를 다 담은, PageResponseDTO 타입으로 변경해서 테스트
  @Test
  public void testListAll() {
    //페이징 정보 임시 데이터 빠져 있음. 추가.
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .keyword("오늘")
        // 검색 조건이, 작성자 또는 제목
        .types(new String[]{"t","w"})
        .from(LocalDate.of(2024,5,1))
        .to(LocalDate.of(2024,5,31))
        .finished(true)
        .build();

    PageResponseDTO<TodoDTO> pageResponseDTO = todoService.listAll(pageRequestDTO);
    log.info("pageResponseDTO : " + pageResponseDTO);
    // 목록 확인
    pageResponseDTO.getDtoList().stream().forEach(todoDTO -> log.info("todoDTO : " + todoDTO));
  // 전체 갯수 확인.
    log.info("전체 갯수 : " +pageResponseDTO.getTotal() );
    // PageRequestDTO 내용물 확인.
    log.info("PageRequestDTO 내용물 확인. : " +pageResponseDTO.getSize() );

  }

  @Test
  public void testGetOne() {
    TodoDTO todoDTO = todoService.getOne(35L);
    log.info("todoDTO : " + todoDTO);
  }

  @Test
  public void testDelete() {
    todoService.delete(34L);

  }

  @Test
  public void testUpdate() {
//    수정 하기위한 더미 데이터 만들기.
    TodoDTO todoDTO = TodoDTO.builder()
        .tno(35L)
        .title("족발 워너비 고씨")
        .dueDate(LocalDate.of(2024,6,1))
        .finished(false)
        .build();

    todoService.update(todoDTO);

  }

  @Test
  public void testGetCount() {
    int result = todoService.getCount();
    log.info("result: todo 전체 갯수 : " + result);

  }

  @Test
  public void testGetCountWithSearch() {
    //페이징 정보 임시 데이터 빠져 있음. 추가.
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .keyword("오늘")
        // 검색 조건이, 작성자 또는 제목
        .types(new String[]{"t","w"})
        .from(LocalDate.of(2024,5,1))
        .to(LocalDate.of(2024,5,31))
        .finished(true)
        .build();
    int result = todoService.getCount2(pageRequestDTO);
    log.info("result: todo 전체 갯수 : " + result);

  }

} // 닫는 블록







