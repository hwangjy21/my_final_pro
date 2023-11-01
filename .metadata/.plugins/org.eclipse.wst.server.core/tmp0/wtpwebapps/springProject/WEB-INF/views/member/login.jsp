<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
.container {
	position: absolute;
	height: 200px;
	top: 30%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<jsp:include page="../common/nav.jsp" />

	<!--email, pwd, nick_name  -->
	<div class="container">
    <!-- 로그인/로그아웃 모두 post -->
    <form action="/member/login" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">email</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" name="email" placeholder="이메일을 입력하세요.">
        </div>

        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">password</label>
            <input type="password" class="form-control" id="exampleFormControlInput2" name="pwd" placeholder="비밀번호를 입력하세요.">
        </div>
        <!-- 에러 메시지가 없을 때는 아무것도 표시하지 않음 -->
	 ${param.errMsg}
        <c:if test="${not empty param.errMsg }">
            <div class="text-danger mb-3">
                <c:choose>
                    <c:when test="${param.errMsg eq 'Bad credentials'}">
                        <c:set var="errText" value="이메일&비밀번호가 일치하지 않습니다."/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="errText" value="관리자에게 물어봥"/>
                    </c:otherwise>
                </c:choose>
                <!-- 에러 메시지 표시 -->
            
                 ${errText}
            </div>
        </c:if>

        <button type="submit" class="btn btn-outline-dark" id="regBtn">로그인</button>
        <br> <br>
    </form>
</div>


	<jsp:include page="../common/footer.jsp" />
</body>
</html>