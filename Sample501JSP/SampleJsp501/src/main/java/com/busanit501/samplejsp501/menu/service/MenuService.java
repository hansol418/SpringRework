package com.busanit501.samplejsp501.menu.service;

import com.busanit501.samplejsp501.menu.dao.MenuDAO;
import com.busanit501.samplejsp501.menu.domain.MenuVO;
import com.busanit501.samplejsp501.menu.dto.MenuDTO2;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MenuService {
  INSTANCE;

  private MenuDAO menuDAO;
  private ModelMapper modelMapper;

  MenuService() {
    menuDAO = new MenuDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  public void register2(MenuDTO2 menuDTO2) throws Exception {

    MenuVO menuVO = modelMapper.map(menuDTO2, MenuVO.class);

    log.info("menuVO : " + menuVO);
    menuDAO.insert(menuVO);
  }

  public List<MenuDTO2> listAll() throws Exception {

    List<MenuVO> sampleList = menuDAO.selectAll();
    log.info("MenuService , 확인1, sampleList : " + sampleList);

    List<MenuDTO2> sampleDtoList = sampleList.stream()
        .map(vo -> modelMapper.map(vo, MenuDTO2.class))
        .collect(Collectors.toList());

    return sampleDtoList;

  }

  // 하나 조회
  public MenuDTO2 getSelectOne(Long menuNo) throws Exception {
    MenuVO sample = menuDAO.selectOne(menuNo);
//    log.info("TodoService , 확인1, sample : " + sample);
    MenuDTO2 menuDTO = modelMapper.map(sample, MenuDTO2.class);
    return menuDTO;
  }

  // 수정
// 화면에서 데이터를 넘겨받아서, DTO 담아서, 여기에 왔음.
  // todoDTO 변경할 데이터가 담겨져 있다.
  public void updateMenu(MenuDTO2 menuDTO2) throws Exception {
   MenuVO menuVO = modelMapper.map(menuDTO2, MenuVO.class);

    // 실제 디비에도 수정.
    menuDAO.update(menuVO);
  }


  // 삭제

  public void deleteMenu(Long menuNo) throws Exception {
    menuDAO.delete(menuNo);
  }
}
