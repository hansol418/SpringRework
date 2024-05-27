<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoReg</title>
</head>
<body>
<h1><%= "임시 todoReg 화면." %>
</h1>
<form method="post" action="/todo/register ">
  <div>
  <input type="text" name="title" placeholder="제목을 입력해주세요.">
  </div>
  <div>
    <input type="date" name="dueDate">
  </div>
  <div>
    <button type="reset">초기화</button>
  <button type="submit">작성</button>
  </div>
</form>
</body>
</html>
