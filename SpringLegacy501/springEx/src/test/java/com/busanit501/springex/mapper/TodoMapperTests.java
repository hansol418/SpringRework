package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.TodoVO;
import com.busanit501.springex.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private TodoMapper todoMapper;

  @Test
  public void testGetTime() {
    log.info("시간 테스트 : " + todoMapper.getTime());
  }

  @Test
  public void testInsert() {
    // 임시 TodoVO , 인스턴스 필요하고,
    TodoVO todoVO = TodoVO.builder()
        .title("돈까스22222222222222222222222222")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용222222222222222222222222222")
        .build();
    todoMapper.insert(todoVO);
  }

  @Test
  public void testSelect() {
    //페이징 정보를 가지고 있는 임시 더미 데이터, PageRequestDTO
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .build();

    List<TodoVO> todoList = todoMapper.listAll(pageRequestDTO);
    todoList.forEach(vo -> log.info("vo : " + vo));
  }

  @Test
  public void testGetOne() {
    TodoVO todoVO = todoMapper.getOne(35L);
    log.info("todoVO : " + todoVO);
  }

  @Test
  public void testDelete() {
    todoMapper.delete(36L);

  }

  @Test
  public void testUpdate() {
    // 변경할 임시 데이터
    TodoVO todoVO = TodoVO.builder()
        .tno(35L)
        .title("초밥 먹기")
        .dueDate(LocalDate.of(2024,5,31))
        .finished(false)
        .build();

    todoMapper.update(todoVO);

     }

  @Test
  public void testGetCount() {
    int result = todoMapper.getCount();
    log.info("result todo 전체 갯수 : " + result);
  }

  // 검색시, 타입에 관련된 테스트
  // 화면 -> 서버, 페이징 정보를 담아서 보내고 , PageRequestDTO + 검색, 필터 준비물
  @Test
  public void testSelectTypes() {
    // 테스트용 더미 PageRequestDTO 만들기.
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

 List<TodoVO> voList  = todoMapper.listAll(pageRequestDTO);
 voList.forEach(vo -> log.info("vo : " + vo ));
  }


  @Test
  public void testGetCountWithSearch() {
    // 테스트용 더미 PageRequestDTO 만들기.
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
    int result = todoMapper.getCount2(pageRequestDTO);
    log.info("result todo 전체 갯수 : " + result);
  }


} // 전체 닫는 블록







