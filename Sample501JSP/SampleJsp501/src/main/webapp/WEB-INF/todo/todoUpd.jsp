<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoUpdate</title>
</head>
<body>
<h1><%= "임시 todo 수정폼 화면." %>
</h1>
<form method="post" action="/todo/update ">
  <div>
<%--   화면에서, EL 표기법 ${sample.title} --%>
<%--    -> 서버에 sample.getTitle()동일한 효과--%>
    <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" >
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" >
  </div>
  <div>
    <input type="checkbox" name="finished" ${sample.finished ? "checked":""} >
  </div>
  <div>
<%--    몰래 tno 번호를 서버에 넘기기, 사용자는 볼수 없음.--%>
    <input type="hidden" name="tno" value="${sample.tno}">
    <button type="submit">수정하기</button>
  </div>
</form>

<%--삭제--%>
<form method="post" action="/todo/delete">
<%--  화면에는 안보임. --%>
  <input type="hidden" name="tno" value="${sample.tno}">
  <button type="submit">삭제하기.</button>
</form>

<form method="get" action="/todo/list">
  <button type="submit">전체메뉴</button>
</form>
</body>
</html>
