<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
메인페이지 입니다.<br>
<c:if test="${empty authInfo}">
<a href="<c:url value='/register/step1'/>">[회원 가입]</a>
<a href="<c:url value='/login'/>">[로그인]</a>
</c:if>

<c:if test="${!empty authInfo}">
<p>${authInfo.name}님 환영합니다.</p>
<a href="<c:url value='/edit/changePassword'/>">[비밀번호 변경]</a>
<a href="<c:url value='logout'/>">[로그아웃]</a>
</c:if>

</body>
</html>