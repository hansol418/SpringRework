package com.busanit501.mini_project.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
  @Select("select now()")
  String getTime();
}

























