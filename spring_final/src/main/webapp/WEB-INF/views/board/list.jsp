<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	margin: 0 auto;
}

h1 {
	text-align: center;
	padding: 20px;
}

table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
}

.container {
	display: flex;
	justify-content: center;
}

table, th, td {
	border: 1px solid #ccc;
	margin: 60px auto;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #35424a;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	text-decoration: none;
	color: #007BFF;
}

a:hover {
	text-decoration: underline;
}

.button {
	background-color: #007BFF;
	color: #fff;
	border: none;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 10px 5px;
	cursor: pointer;
	border-radius: 5px;
}

.button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/nav.jsp" />

	<h1>게시판</h1>

	<div class="container">
		<div class="col-sm-12 col-md-6">
			<form action="/board/list" method="get">
				<div class="input-group mb-3">
					<c:set value="${ph.pgvo.type }" var="typed" />
					<select class="form-select" name="type" id="inputGroupSelect01">
						<option ${typed eq null ? 'selected' : '' }>Choose...</option>
						<option value="t" ${typed eq 't'? 'selected' : '' }>Title</option>
						<option value="w" ${typed eq 'w'? 'selected' : '' }>Writer</option>
						<option value="c" ${typed eq 'c'? 'selected' : '' }>Content</option>
						<option value="tw" ${typed eq 'tw'? 'selected' : '' }>Title
							or Writer</option>
						<option value="tc" ${typed eq 'tc'? 'selected' : '' }>Title
							or Content</option>
						<option value="cw" ${typed eq 'cw'? 'selected' : '' }>Content
							or Writer</option>
						<option value="twc" ${typed eq 'twc'? 'selected' : '' }>all</option>
					</select> <input class=class= "form-control me-2" name="keyword"
						value="${ph.pgvo.keyword }" type="search" placeholder="Search"
						aria-label="Search"> <input type="hidden" name="pageNo"
						value="1"> <input type="hidden" name="qty"
						value="${ph.pgvo.qty }">
					<button class="btn btn-outline-success" type="submit">
						Search <span
							class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
							${ph.totalCount } <span class="visually-hidden">unread
								messages</span>
						</span>
					</button>
			</form>
		</div>



		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Writer</th>
					<th scope="col">Read Count</th>
					<th scope="col">comment_qty</th>
					<th scope="col">file_qty</th>
					<th scope="col">Mod At</th>
					<th scope="col">Reg At</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="post">
					<tr>
						<td>${post.bno}</td>
						<td><a href="/board/detail?bno=${post.bno}">${post.title}</a></td>
						<td>${post.writer}</td>
						<td>${post.readCount}</td>
						<td>${post.cmtQty }</td>
						<td>${post.fileQty }</td>
						<td>${post.regAt }</td>
						<td>${post.modAt }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
