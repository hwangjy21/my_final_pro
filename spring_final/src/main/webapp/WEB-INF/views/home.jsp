<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <html> -->
<!-- <head> -->
<!--    <title>Index Page</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- <jsp:include page="common/header.jsp"/> --%>
<%-- <jsp:include page="common/nav.jsp"/> --%>

<!-- <h3> -->
<!-- 메인입니다. -->
<!-- </h3> -->

<%-- <jsp:include page="common/footer.jsp"/> --%>
<!-- </body> -->
<!-- </html> -->
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard Index Page</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/resources/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/resources/css/r_side.css'/>" rel="stylesheet"
	type="text/css">
<jsp:include page="common/footer.jsp" />
</head>


<body>

	<!-- nav -->
	<nav>nav</nav>

	<!--오른쪽 사이드 메뉴  -->
	<div class="right_sidemenu_div">
		<ul class="right_sidemenu">
			<li><a href="#" class="">예약</a>
				<div class="toggle-btn">&#9776; Open</div>

				<ul class="submenu">
					<li><a href="#">주차등록</a></li>
					<li><a href="#">회의실예약</a></li>
					<li><a href="#">휴가</a></li>

				</ul></li>
			<li><a href="#">게시판</a>
				<ul class="submenu">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">부서게시판</a></li>
					<li><a href="#">익명게시판</a></li>

				</ul></li>
			<li><a href="#">동호회</a>
				<ul class="submenu">
					<li><a href="#">동호회신청</a></li>
					<li><a href="#">동호회게시판</a></li>

				</ul></li>
			<li><a href="#">승인</a>
				<ul class="submenu">
					<li><a href="#">동호회 등록</a></li>
					<li><a href="#">차량 등록</a></li>
					<li><a href="#">사원 등록</a></li>
					<li><a href="#">사원 목록</a></li>

				</ul></li>
			<li><a href="#">MENU5</a>
				<ul class="submenu">
					<li><a href="#">submenu01</a></li>
					<li><a href="#">submenu02</a></li>
					<li><a href="#">submenu03</a></li>
					<li><a href="#">submenu04</a></li>
					<li><a href="#">submenu05</a></li>
				</ul></li>
		</ul>

	</div>







<!-- Bootstrap core JavaScript-->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../resources/js/sb-admin-2.min.js"></script>

<script src="../resources/js/Nav.css"></script>

<!-- Page level plugins -->
<script src="../resources/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="../resources/js/demo/chart-area-demo.js"></script>
<script src="../resources/js/demo/chart-pie-demo.js"></script>
<%-- <jsp:include page="common/footer.jsp"/> --%>



</body>

</html>