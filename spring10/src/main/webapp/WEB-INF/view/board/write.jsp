<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성하기</title>
</head>
<body>
<form:form method="post" commandName="boardVo">
	<table border="1">
		<tr>
			<th><form:label path="title">제목</form:label></th>
			<td>
			<form:input path="title"/>
			<form:errors path="title"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="content">내용</form:label></th>
			<td><form:input path="content"/><form:errors path="content"/></td>
		</tr>
		<tr>
			<th><form:label path="writer">작성자</form:label></th>
			<td><form:input path="writer"/><form:errors path="writer"/></td>
		</tr>
		<tr>
			<th><form:label path="password">비밀번호</form:label></th>
			<td><form:password path="password"/><form:errors path="password"/></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="등록">
	</div>
</form:form>
<a href="<c:url value="/board/list"/>"><button>목록</button></a>
</body>
</html>