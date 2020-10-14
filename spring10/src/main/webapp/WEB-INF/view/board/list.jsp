<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<table border="1">
   <tr>
      <th>NO</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>조회수</th>
   </tr>
   <c:forEach var="board" items="${boardList}" varStatus="loop">
      <tr>
         <td>${board.seq}</td>
         <td>
         <a href="<c:url value="/board/read/${board.seq}"/>">${board.title}</a>
         </td>
         <td>${board.writer}</td>
         <td>${board.regDate}</td>
         <td>${board.cnt}</td>
      </tr>
   </c:forEach>
</table>
   <a href="<c:url value="/board/write"/>"><button>새 글</button></a>
   
</body>
</html>