<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
	<div class="con		<h1>글 수정</h1>tainer">

		<form action="/board/modify" method="post" enctype="multipart/form-data">
			<div class="container">
				<h1>글 디테일</h1>
				<c:set value="${bdto.bvo }" var="bvo"></c:set>
				<input type="hidden" id="bno" name="bno" value="${bvo.bno }">
				<label for="title">제목:</label> <input type="text" id="title"
					name="title" value="${bvo.title }"> <label for="title">작성자:</label>
				<input type="text" id="writer" name="writer" value="${bvo.writer }">
				<label for="content">내용:</label>
				<textarea id="content" name="content" rows="6">${bvo.content }</textarea>
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

				<div>
					<ul>

						<!-- file 개수 만큼 li를 추가하여 파일을 표시 타입이 1일 경우만 표시-->
						<!-- li 
					div => img 그림표시
					div=> div 파일이름 , 작성일자 span 크기 설정
						 -->
						<c:set value="${bdto.flist}" var="flist"></c:set>
						<!-- 하나의 파일만 따와서 fvo로 저장 -->
						<c:forEach items="${flist}" var="fvo">
							<li style="margin-left: -1%; list-style: none;"><c:choose>
									<c:when test="${fvo.fileType>0 }">
										<div>

											<!-- /upload/year/month/dat/uuid_(th)_file_name -->

											<img style="width: 300px; height: 300px;" alt="그림 없당"
												src="/upload/${fn: replace(fvo.saveDir,'\\','/')}/
										${fvo.uuid}_${fvo.fileName}">

										</div>
									</c:when>
									<c:otherwise>

										<div>
											<!-- file 아이콘 같으 모양 값으로 넣을 수 있음 -->
										</div>
									</c:otherwise>

								</c:choose>
								<div>
									<br>

									<h4>
										${fvo_uuid}_${fvo.fileName } <span class="badge bg-secondary">
											${fvo.fileSize }byte</span>
										<button type="button" data-uuid="${fvo.uuid}"
											class="btn btn-sm btn-danger py-0 file-x">X</button>
									</h4>
								</div>


								<hr></li>
						</c:forEach>


					</ul>
					<button type="submit" type="submit" class="btn btn-dark"
						id="regBtn">작성</button>
				</div>
		</form>

	</div>

	<script type="text/javascript" src="/resources/js/boardRegister.js"></script>
		<script type="text/javascript" src="/resources/js/boardModify.js"></script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>

