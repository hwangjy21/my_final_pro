<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style type="text/css">
        /* 페이지 전체 스타일링 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

     
        /* 제목 스타일링 */
        h3 {
            font-size: 24px;
            color: #333;
            margin: 100px;
            
			padding: 10%;            
        }
        
        
    </style>
</head>
<body>
    <header>
        <jsp:include page="common/header.jsp" />
    </header>

    <nav>
        <jsp:include page="common/nav.jsp" />
    </nav>

    <div class="content">
        <h3>오늘 너무 졸립다 ㅋㅋㅋ</h3>
    </div>

    <footer>
        <jsp:include page="common/footer.jsp" />
    </footer>
</body>
</html>
