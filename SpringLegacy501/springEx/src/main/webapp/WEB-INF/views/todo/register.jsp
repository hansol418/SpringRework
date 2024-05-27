<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoReg 화면 재사용</title>
</head>
<body>
<h1><%= "임시 todo - register 화면." %>
</h1>
<form method="post" action="/todo/ex6">
  <input type="hidden" name="tno" value="1">
  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요.">
  </div>
  <div>
    <input type="date" name="dueDate">
  </div>
  <div>
    <input type="text" name="writer" placeholder="작성자를 입력해주세요.">
  </div>
  <div>
<<<<<<< HEAD
    Finished: <input type="checkbox" name="finished" >
=======
   Finished: <input type="checkbox" name="finished" >
>>>>>>> origin/main
  </div>
  <div>
    <button type="reset">초기화</button>
    <button type="submit">작성</button>
  </div>
</form>
</body>
</html>
