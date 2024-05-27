<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - menuSignup.jsp</title>
</head>
<body>

<form action="/menuSignup" method="post">
  <input type="text" name="mid" placeholder="아이디를 입력해주세요.">
  <input type="text" name="mname" placeholder="이름 입력해주세요.">
  <input type="password" name="mpw"placeholder="패스워드를 입력해주세요.">
  <input type="password" name="mpw2"placeholder="패스워드를 확인해주세요.">
  <br>
  <button type="reset">초기화</button>
  <button type="submit">회원가입</button>
</form>
</body>
</html>
