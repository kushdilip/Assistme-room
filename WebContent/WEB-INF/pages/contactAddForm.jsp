<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Add Page</title>
<link href="resources/styles/error.css" rel="stylesheet" type="text/css" />
<link href="resources/styles/main.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/menubar.jsp"></jsp:include>

	<div align="center">
		<h2>Add New Contact</h2>

		<form:form method="POST" commandName="contact">
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Mobile :</td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input class="button" type="submit"
						value="Add" /></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input class="button" type="button"
						value="Cancel" onClick="window.location.href='showContacts.html'"></td>

				</tr>
			</table>
		</form:form>


	
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>