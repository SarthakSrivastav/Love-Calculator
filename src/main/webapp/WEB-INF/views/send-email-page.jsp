<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>send-email-page</title>
</head>
<body style="background: pink;">

	<div align="center">
		<h1>Hi ${userInfo.userName}</h1>
		<h2>Share this result with your loved ones.</h2>
		<form:form action="validateEmailID" method="get"
			modelAttribute="emailDto">
			<label for="eid">Enter Email Id : </label>
			<form:input path="email" id="eid" />
			<input type="submit" value="Send">
		</form:form>
	</div>

</body>
</html>