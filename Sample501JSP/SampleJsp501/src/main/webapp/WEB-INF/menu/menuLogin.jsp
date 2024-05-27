<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - menuLogin.jsp</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
<h1>로그인에러</h1>
</c:if>
<form action="/menuLogin" method="post">
  <input type="text" name="mid" placeholder="아이디를 입력해주세요.">
  <input type="password" name="mpw"placeholder="패스워드를 입력해주세요.">
  <label for="auto">자동로그인</label>
  <input type="checkbox" name="auto" id="auto">
  <button type="submit">로그인</button>
</form>
<form action="/menuSignup" method="get">
  <button type="submit">회원가입</button>
</form>

</body>
</html>
