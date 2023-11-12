<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Page</title>
<style type="text/css">
.btn{
margin: 10px;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</head>
<body>
<%-- <jsp:include page="../common/nav.jsp"/> --%>

<div class="container">
<form action="/board/register" method="post" enctype="multipart/form-data">
<div class="mb-3">
  <label for="w" class="form-label">WRITER</label>
  <input type="text" class="form-control" id="w" name="writer">
</div>
<div class="mb-3">
  <label for="t" class="form-label">TITLE</label>
  <input type="text" class="form-control" id="t" name="title">
</div>
<div class="mb-3">
  <label for="c" class="form-label">CONTENT</label>
  <textarea class="form-control" id="c" rows="3" name="content"></textarea>
</div>

<div class="mb-3">
  <label for="f" class="form-label">FILE_UPLOAD</label>
  <input class="form-control" type="file" id="files" name="files" multiple="multiple">
</div> 
<div id="fileZone">
<!-- 파일 출력하는 부분 -->
</div>

<div class="btnContainer">
<button type="submit" class="btn btn-outline-primary" id="regBtn">등록</button>
<a href="/"><button type="button" class="btn btn-outline-primary" type="button">HOME</button></a>
</div>
</form>
</div>

<%-- <jsp:include page="../common/footer.jsp"/> --%>
<!-- <script type="text/javascript" src="/resources/js/file.js"></script> -->
</body>
</html>