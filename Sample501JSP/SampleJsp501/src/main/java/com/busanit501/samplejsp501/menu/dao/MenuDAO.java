package com.busanit501.samplejsp501.menu.dao;

import com.busanit501.samplejsp501.menu.domain.MenuVO;
import com.busanit501.samplejsp501.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
  public List<MenuVO> selectAll() throws Exception{
    String sql = "select * from lunchmenu";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    @Cleanup ResultSet resultSet = pstmt.executeQuery();

    List<MenuVO> samples = new ArrayList<MenuVO>();

    while (resultSet.next()){
      MenuVO menuVOBuilder = MenuVO.builder()
          .menuNo(resultSet.getLong("menuNo"))
          .menuTitle(resultSet.getString("menuTitle"))
          .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
          .build();
      samples.add(menuVOBuilder);
    }
    return samples;
  }

  //상세보기, 하나 게시글 조회
  public MenuVO selectOne(Long menuNo) throws Exception{
    String sql = "select * from lunchmenu where menuNo = ?";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setLong(1,menuNo);
    @Cleanup ResultSet resultSet = pstmt.executeQuery();

    resultSet.next();

      MenuVO menuVOBuilder = MenuVO.builder()
          .menuNo(resultSet.getLong("menuNo"))
          .menuTitle(resultSet.getString("menuTitle"))
          .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
          .build();
    return menuVOBuilder;
  }
  // 쓰기,
  public void insert(MenuVO menuVO) throws Exception{
    String sql = "insert into lunchmenu ( menuTitle, menuRegDate) values (?,?);";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,menuVO.getMenuTitle());
    pstmt.setDate(2, Date.valueOf(menuVO.getMenuRegDate()));

    pstmt.executeUpdate();

  }

  // 수정
  public void update(MenuVO menuVO) throws Exception{
    String sql = "update lunchmenu set  menuTitle = ?, menuRegDate = ? where menuNo = ?";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,menuVO.getMenuTitle());
    pstmt.setDate(2, Date.valueOf(menuVO.getMenuRegDate()));
    pstmt.setLong(3, menuVO.getMenuNo());

    pstmt.executeUpdate();

  }

  // 삭제
  public void delete(Long menuNo) throws Exception{
    String sql = "delete from lunchmenu where menuNo = ?;";

    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setLong(1, menuNo);

    pstmt.executeUpdate();

  }

}







