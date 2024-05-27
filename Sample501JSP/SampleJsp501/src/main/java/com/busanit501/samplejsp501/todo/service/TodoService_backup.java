package com.busanit501.samplejsp501.todo.service;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService_backup {
  INSTANCE;
  //데이터베이스에, crud 작업을 하기위한 도구들의 모음.
  // todo , 작성, 조회, 수정, 삭제 기능들의 모음집.
  // 데이터베이스 접근할 때,
  // 1)
  // 인터페이스, 디비 URL 주소, 유저명, 패스워드 정보로 접근 하기 위한
  // 인스턴스
  // 2) PreparedStatement 인터페이스, sql 전달하기 위한, 또한 실행하기 위한 도구.
  // 3) ResultSet(조회시, 결과 데이터를 받는 테이블 )
  // 많은 도구(인스턴스 이용이 됨),
  // 자원 반납, close()  호출후 반납.
  // DBCP Pool 기능(도구),
  // 매번 만들 때 자원 소모가 심해요 -> 미리 만들어 놓고, 재사용 하면 어떻까?
  // 톰캣 서버, 끄고, 다시 켜면, 자원 소모가 많아요.
  // 톰캣 서버를 켜 두고, 변경 사항에 대해서만 deploy all 기능을 이용중.
  // 결론, 싱글톤 패턴.
  // 연결할 때 필요한 인스턴스는 하나면 충분함.

  // 샘플 등록하는 코드 ,
  // 정보를 받을 때, 양식을 , TodoDTO 타입을 만들었음. 여기에 담아서 전달용으로 사용할 예정.
  public void register(TodoDTO dto) {
    System.out.println("debug register dto 확인중 : " + dto);
  }

  // 임시 리스트 출력하는 기능.
  public List<TodoDTO> getList() {
    //샘플로, 더미 데이터 생성하기.
    // 자바 -> 병렬 처리(stream) , 중간 처리, 최종처리 단계로 진행.
    // 데이터 전달할 때 사용하는 (stream)
    // 리스트 안에서, 각 요소를 꺼내어서, 하나씩 작업 후 무언가 처리함.
    // map -> 대응되다, 예) 사랑의 짝대기, 남자1 --> 여자1, 여자1 --> 남자2
    // 예) 바나나 ---> banana,
    // mapToObj 작성시 자동 임포트 잘하기.
    List<TodoDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
      // 임시 Todo 하나를 의미,
          TodoDTO dto = new TodoDTO();
          dto.setTno((long)i);
          dto.setTitle("Sample Todo Title " + i);
          dto.setDueDate(LocalDate.now());
          return dto;
        }).collect(Collectors.toList());
    return listSample;
  }

  public List<TodoDTO> getList2() {
    // 임시로 10개의 더미 데이터를 담을 공간.
    List<TodoDTO> sampleList = new ArrayList<>();

    for (int i = 0; i <10; i++) {
      TodoDTO dto = new TodoDTO();
      dto.setTno((long)i);
      dto.setTitle("Sample Todo" + i);
      dto.setDueDate(LocalDate.now());
      sampleList.add(dto);
    }
    return sampleList;
  }

}
