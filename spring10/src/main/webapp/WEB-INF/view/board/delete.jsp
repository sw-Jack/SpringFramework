<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
<form method="post" action="<c:url value="/board/delete"/>">
	<input type="text" name="seq" value="${seq}">번 글을 삭제하시겠습니까?<br>
	비밀번호:<input type="password" name="pwd">
	<input type="submit" value="삭제">
</form>	
	<a href="<c:url value="/board/read/${seq}"/>"><button>취소</button></a>
	<div>${msg}</div>
</body>
</html>