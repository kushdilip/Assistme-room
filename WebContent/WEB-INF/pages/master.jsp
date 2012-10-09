<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <link href="resources/styles/reset.css" rel="stylesheet" type="text/css" />
 -->
<link href="resources/styles/error.css" rel="stylesheet" type="text/css" />
<link href="resources/styles/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="container" style="width: 100%">
		<div id="header" style="background-color: #FFA500;" align="center">
			<h1 style="margin-bottom: 0;">AssistMe</h1>
			<h3>Your own Personal Assistant</h3>
		</div>

		<div id="loginbar" align="left"
			style="background-color: #FFD700; height: 490px; width: 350px; float: right; font-size: large; font-weight: bold;">
			<p>
				New User <a href="userRegistration.html"><b>Register</b></a>
			</p>

			<p>Already Registered, Please Login</p>

			<form:form commandName="user" method="POST">
				<table>
					<tr>
						<td>Email Id:</td>
						<td><form:input path="emailId" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="password" type="password" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Login"></td>
					</tr>
					<tr>
						<td colspan="2"><form:errors path="emailId" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="2"><form:errors path="password" cssClass="error" /></td>
					</tr>

				</table>
			</form:form>

		</div>


		<div id="footer"
			style="background-color: #FFA500; clear: both; text-align: center;">
			Copyright © </div>
	</div>

</body>
</html>