<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
}

th {
	background-color: #333;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/nav.jsp" />

	<div class="container text-center">
		<table>
			<thead>
				<tr>
					<th>Email</th>
					<th>Nickname</th>
					<th>Registration Date</th>
					<th>Last Login Date</th>
					<th>Authorities</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memList}" var="mvo">
					<tr>
						<td>${mvo.email}</td>
						<td>${mvo.nickName}</td>
						<td>${mvo.regAt}</td>
						<td>${mvo.lastLogin}</td>
						<td><c:forEach items="${mvo.authList}" var="auth">
                            ${auth.auth}
                            <c:if test="${not empty authList.last}">, </c:if>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>
