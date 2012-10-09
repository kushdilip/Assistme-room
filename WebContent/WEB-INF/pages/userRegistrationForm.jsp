<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/styles/error.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="container" style="width: 100%">
		<div id="header" style="background-color: #FFA500;" align="center">
			<h1 style="margin-bottom: 0;">AssistMe</h1>
			<h3>Your own Personal Assistant</h3>
		</div>
		<div id="registrationForm" align="center" style="height: 80%;">
			<h2>Registration Form</h2>
			<form:form method="POST" commandName="user">
				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><form:input path="emailId" /></td>
						<td><form:errors path="emailId" cssClass="error" /></td>

					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="password" type="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Confirm Password:</td>
						<td><form:input path="confirmPassword" type="password" /></td>
						<td><form:errors path="confirmPassword" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td align="center" colspan="2"><input type="submit"
							value="Add" /></td>
					</tr>
					<tr>
						<td></td>
						<td align="center" colspan="2"><input type="button"
							value="Cancel" onClick="window.location.href='index.html'"></td>
					</tr>

				</table>

			</form:form>

		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>