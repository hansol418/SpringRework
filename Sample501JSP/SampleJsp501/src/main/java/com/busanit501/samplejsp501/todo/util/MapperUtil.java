package com.busanit501.samplejsp501.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
  INSTANCE;

  // 멤버로, modelMapper 필요함. 주입, 포함, DI
  private ModelMapper modelMapper;

  // 양방향 변환에 필요한 초기 설정.

  // 기본 생성자에서, 설정되게 하기.
  MapperUtil(){
    // 위에서 주입했던 인스턴스를 선언만 해서, 여기서 할당을 함.
    // 0x100 이 할당이 됨.
    this.modelMapper = new ModelMapper();
    // 추가 설정은,
    this.modelMapper.getConfiguration()
        // VO <-> DTO 간의 멤버의 일치성 여부를 확인
        .setFieldMatchingEnabled(true)
        // 멤버의 접근 지정자를 private 에 접근하기위해서 필요한 설정.
        // 기본 , public , default
    .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
        // VO <-> DTO 간의 검사를 , 꼼꼼하게 해주세요.(정확히 일치해야함.)
        .setMatchingStrategy(MatchingStrategies.STRICT);
  } // 기본 생성자 닫기. MapperUtil

  // ModelMapper 타입의 인스턴스를 반환하는 메서드 만들기.
  public ModelMapper get() {
    return modelMapper;
  }
}
