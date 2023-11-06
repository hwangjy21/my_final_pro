<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.container_cmt {
	margin-top: 20px;
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

		<div class="container_cmt">
			<!-- 댓글 등록 라인 -->
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.mvo.email" var="authEmail" />
				<div class="input-group mb-3">
					<span class="input-group-text" id="cmtWriter">익명</span> <input
						type="text" class="form-control" placeholder="Test Comment"
						id="cmtText" style="margin: 0;">
					<button type="button" class="btn btn-success" id="cmtPostBtn">Post</button>
				</div>


			</sec:authorize>
			<!-- 댓글 표시 라인 -->
			<ul class="list-group list-group-flush" id="cmtListArea">
				<li class="list-group-item">
					<div class="mb-3">
						<div class="fw-bold">Wirter</div>
						Content
					</div> <span class="badge rounded-pill text-bg-dark">modAt</span>
				</li>

			</ul>

			<!-- 댓글 페이징 라인 -->
			<div>
				<div>
					<button type="button" id="moreBtn" data-page="1"
						class="btn btn-outline-dark" style="visibility: hidden">MORE+</button>
				</div>
			</div>
			<div class="modal" id="myModal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<h5 class="modal-title"></h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>

						<div class="modal-body">
							<div class="input-group mb-3">
								<input type="text" class="form-control"
									placeholder="Test Comment" id="cmtTextMod">
								<button type="button" class="btn btn-success" id="cmtModBtn">Post</button>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

		</div>
		<script>
			let bnoVal = `<c:out value="${bvo.bno}" />`;
			console.log(bnoVal);
			getCommentList(bnoVal);
		</script>
		<script type="text/javascript" src="/resources/js/boardComment.js"></script>
		<jsp:include page="../common/footer.jsp" />
</body>
</html>
