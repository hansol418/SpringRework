<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <!--    NavBar 가져와서 적용해보기-->
    <div class="col">
      <nav class="navbar navbar-expand-lg " style="background-color: #b0f89d;">
        <!--      <nav class="navbar bg-primary navbar-expand-lg bg-body-tertiary bg-primary"  data-bs-theme="" >-->
        <!--      <nav class="navbar bg-primary" data-bs-theme="dark">-->
        <div class="container-fluid">
          <a class="navbar-brand" href="/todo/list">목록가기</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" aria-disabled="true">Disabled</a>
              </li>
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
    </div>
  </div>
  <!--  Navbar 종료-->
  <!--  본문 시작-->
  <div class="row content">
    <div class="col">
      <!--      부트 스트랩 5.3 Card 컴포넌트 Header and Footer 의 샘플 가져오기-->
      <div class="card">
        <div class="card-header">
          Featured
        </div>
        <div class="card-body">
<%--         register.jsp 의 화면을 복붙--%>
  <form method="post" action="/todo/update">
    <input type="hidden" name="tno" value="${todoDTO.tno}">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력해주세요." value="${todoDTO.title}" >
    </div>
    <div class="mb-3">
      <label for="dueDate" class="form-label">일정</label>
      <input type="date" name="dueDate" class="form-control" id="dueDate" value="${todoDTO.dueDate}" >
    </div>

    <div class="mb-3">
      <label for="writer" class="form-label">작성자</label>
      <input type="text" name="writer" class="form-control" id="writer" placeholder="작성자를 입력해주세요."value="${todoDTO.writer}" readonly>
    </div>

    <div class="mb-3">
      <label class="form-check-label" for="finished">Finished</label>
      <input type="checkbox" class="form-check-input" id="finished" name="finished" ${todoDTO.finished ? "checked" :""}>
    </div>

     <div class="mb-3">
      <button type="submit" class="btn btn-primary">수정하기</button>
      <button type="button" class="btn btn-danger">목록가기</button>
    </div>
  </form>
  <form method="post" action="/todo/delete">
    <input type="hidden" name="tno" value="${todoDTO.tno}">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">
    <button type="submit" class="btn btn-warning">삭제하기</button>
  </form>


  <script>
    const serverValidErrors = {}
    <c:forEach items = "${errors}" var="error">
    serverValidErrors['${error.getField()}'] = '${error.defaultMessage}'
    </c:forEach>
    console.log(serverValidErrors)
    alert("유효성 오류입니다. 입력값 확인해주세요.")
    // form 태그의 요소를 선택하기. -> 기본이 action -> /todo/update, 변경, post 방식.
    // const formObject = document.querySelector("form")
    //
    // document.querySelector(".btn-warning").addEventListener("click",function(event){
    //   event.preventDefault()
    //   event.stopPropagation()
    //
    //   formObject.action = "/todo/delete"
    //   formObject.method = "post"
    //   formObject.submit()
    // }, false)

    document.querySelector(".btn-danger").addEventListener("click", function(event) {
      self.location = "/todo/list?${pageRequestDTO.link}"

    },false);
  </script>
        </div>
      </div>
    </div>
  </div>
  <div class="row footer">
    <div class="row fixed-bottom" style="z-index: -100">
      <footer class="py-1 my-1">
        <p class="text-center text-muted">Footer</p>
      </footer>
    </div>

  </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
