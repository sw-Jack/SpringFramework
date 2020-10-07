<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" commandName="formData">
	<p>
		<label><spring:message code="email"/><form:input path="email"/></label>
	</p>
	<p>
		<label><spring:message code="name"/><form:input path="name"/></label>
	</p>
	<p>
		<label><spring:message code="password"/><form:password path="password"/></label>
	</p>
	<p>
		<label><spring:message code="password.confirm"/><form:password path="confirmPassword"/></label>
	</p>
	<input type="submit" value="<spring:message code="register.btn"/>">
	</form:form>
</body>
</html>