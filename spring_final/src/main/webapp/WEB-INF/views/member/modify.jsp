<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-label {
	font-weight: bold;
	margin-bottom: 5px;
}

.form-control {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.btn {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/nav.jsp" />
	<!-- email, pwd, nick_name -->
	<div class="container">
		<h4 class="mb-3">회원가입 수정</h4>
		<form action="/member/modify" method="post">


			<div class="mb-3">
				<label for="e" class="form-label">email</label> <input type="email"
					class="form-control" name="email" id="e" readonly="readonly"
					placeholder="example@OOO.com" value="${mem.email}">
			</div>
			<div class="mb-3">
				<label for="p" class="form-label">pwd</label> <input type="password"
					class="form-control" name="pwd" id="p" placeholder="password"
					value="${mem.pwd }">
			</div>


			<button class="w-100 btn btn-primary btn-lg my-5" type="button"
				onclick="Confirmation()">비밀번호 변경</button>
			<div class="mb-3">
				<label for="n" class="form-label">nick_name</label> <input
					type="text" class="form-control" name="nickName" id="n"
					value="${mem.nickName }">
			</div>
			<button class="w-100 btn btn-primary btn-lg my-5" type="submit">Register</button>
		</form>

		<a href="/member/remove?email=${mem.email}" id="delBtn"
			class="btn btn-outline-danger">DEL</a>
	</div>

	<script>
		function Confirmation() {

			const confirmation = confirm("비밀번호를 지우시겠습니까?");

			if (confirmation) {

				const PasswordInput = document.getElementById("p");

				PasswordInput.value = "";

			}

		}
	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>