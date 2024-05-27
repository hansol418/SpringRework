<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<ul>
  <h1>${memberDTO.mname}님 환영합니다.</h1>
  <div>
    <form method="post" action="/logout">
        <button type="submit">로그아웃</button>
    </form>
  </div>
  <c:if test="${memberDTO.autoLogined == true}">
  <div>
    <form method="post" action="/noauto">
      <h1>공용으로 사용하는 공간에서는 꼭 자동로그인 해제 해주세요!!</h1>
      <button type="submit">자동로그인해제</button>
    </form>
  </div>
  </c:if>
  <button><a href="/todo/register">Todo작성</a></button>
<%--  서버 컨트롤러에서 전달 받은 박스, 라벨 이름: list, --%>
<%--  내용물: 디비에서 가져온 10개의 값--%>
  <c:forEach items="${list}" var="dto">
    <li>
      <span>
        <a href="/todo/read?tno=${dto.tno}">${dto.tno}</a>
      </span>
      <span>
        ${dto.title}
      </span>
      <span>
          ${dto.dueDate}
      </span>
      <span>
          ${dto.finished ? "완료" : "미완료"}
      </span>
    </li>
  </c:forEach>
</ul>

</body>
</html>
