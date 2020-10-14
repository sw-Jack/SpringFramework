<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVo.title}&nbsp;내용</title>
</head>
<body>
<table border="1">
	<tr><th>제목</th><td>${boardVo.title}</td></tr>
	<tr><th>내용</th><td>${boardVo.content}</td></tr>
	<tr><th>작성자</th><td>${boardVo.writer}</td></tr>
	<tr><th>작성일</th><td>${boardVo.regDate}</td></tr>
	<tr><th>조회수</th><td>${boardVo.cnt}</td></tr>
</table>
<div>
	<a href="<c:url value="/board/edit/${boardVo.seq}"/>"><button>수정</button></a>
	<a href="<c:url value="/board/list"/>"><button>목록</button></a>
</div>
</body>
</html>