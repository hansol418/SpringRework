<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - result1.jsp</title>
</head>
<body>
<%--action 속성의 값으로 서버에서 처리할 서블릿 주소를 입력 하면 됨.--%>
<h1>input.jsp 에서 보낸 파라미터 정보를 받아서 출력하는 결과 파일. </h1>
<%--${} EL 표기법이라고해서, 서버에서 특정의 데이터를 가져올 때 많이 사용하는 문법. --%>
<%--반환 타입은 문자열 이다. 주의사항,--%>
<h1>넘어온 데이터 num1 : ${param.num1}</h1>
<h1>넘어온 데이터 num2 : ${param.num2}</h1>
<h1>넘어온 데이터 데이터 타입은 항상 문자열이다. 확인. </h1>
<h1>넘어온 데이터 num1 + num2 : ${param.num1} + ${param.num2}</h1>
<h1>넘어온 데이터 정수형으로 변환해보기 </h1>
<%--현재, html 문서 안에, 자바 코드를 넣어서 작업을 하는 형태, 모델 1, --%>
<%--코드 가독성이 떨어지고, 전체 코드 길이가 길어짐, 유지보수가 어렵다. --%>
<%---> --%>
<%--결론, 브라우저 요청 -> 서블릿 클래스 파일 -> 화면(뷰) jsp 파일 전달하는 형식으로해서, --%>
<%--jsp에서는 html 관련 코드만 남기고, 자바 코드는 분리하는 형태, 모델2--%>
<h1>넘어온 데이터 num1 + num2 : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
