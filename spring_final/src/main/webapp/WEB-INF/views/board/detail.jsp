<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


	<div class="container">
		<h1>글 디테일</h1>
		<input type="hidden" id="bno" name="bno" value="${bvo.bno }">
		<label for="title">제목:</label> <input type="text" id="title"
			name="title" value="${bvo.title }" readonly="readonly"> <label
			for="title">작성자:</label> <input type="text" id="writer" name="writer"
			value="${bvo.writer }" readonly="readonly"> <label
			for="content">내용:</label>
		<textarea id="content" name="content" rows="6" readonly="readonly">${bvo.content }</textarea>


		<label for="title">등록 날짜</label> <input type="text" id="regAt"
			name="title" value="${bvo.regAt }" readonly="readonly"> <label
			for="title">수정날짜</label> <input type="text" id="writer" name="modAt"
			value="${bvo.modAt }" readonly="readonly"> <label for="title">조회수</label>
		<input type="text" id="readCount" name="readCount"
			value="${bvo.readCount }" readonly="readonly"> <a
			href="/board/modify?bno=${bvo.bno }" id="modBtn"
			class="btn btn-outline-warning">MOD</a> <a
			href="/board/remove?bno=${bvo.bno }" id="delBtn"
			class="btn btn-outline-danger">DEL</a>
	</div>


	<jsp:include page="../common/footer.jsp" />
</body>
</html>
