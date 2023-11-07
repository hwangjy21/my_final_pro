<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #35424a;
	text-align: center;
}

form {
	margin: 20px 0;
}

label {
	font-weight: bold;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	background-color: #007BFF;
	color: #fff;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/nav.jsp" />
	<sec:authentication property="principal.mvo.email" var="auth"/>
	<div class="container">
	
		<h1>글 작성</h1>
		<form action="/board/register" method="post"
			enctype="multipart/form-data">
			
			<label for="title">제목:</label> <input type="text" id="title"
				name="title"> <label for="title">작성자:</label> <input
				type="text" id="writer" name="writer" value="${auth }"> <label for="content">내용:</label>
			<textarea id="content" name="content" rows="6"></textarea>
			<div class="mb-3">
				<input type="file" class="form-control" name="files" id="files"
					style="display: none;" multiple="multiple">
				<!-- input button trigger 용도의 button -->
				<button type="button" id="trigger" class="btn btn-outline-primary">File
					Upload</button>
			</div>
			<div class="mb-3" id="fileZone">
				<!-- 첨부파일 표시될 영역 -->
			</div>

			<button type="submit" type="submit" class="btn btn-dark" id="regBtn">작성</button>
		</form>

	</div>

	<script type="text/javascript" src="/resources/js/boardRegister.js"></script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>

