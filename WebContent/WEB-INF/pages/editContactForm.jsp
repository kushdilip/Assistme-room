<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/menubar.jsp"></jsp:include>

	<h1>Edit Contact</h1>

	<form:form method="POST" commandName="contact">
		<form:input type="hidden" path="id" value="${contact.id}" />
	Name:<form:input path="name" value="${contact.name}" />
	Mobile:<form:input path="phoneNumber" value="${contact.phoneNumber}" />
	Email: <form:input path="emailId" value="${contact.emailId}" />
		<input type="submit" value="submit" />
		<input type="button" value="Cancel"
			onClick="window.location.href='showContacts.html'">
	</form:form>
	<br>


	<a href="showContacts.html">Go back to All Contacts Page</a>


</body>
</html>