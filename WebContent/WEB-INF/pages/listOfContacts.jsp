<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Contacts</title>

</head>


<body>

	<div id="container" style="width: 100%">

		<jsp:include page="../common/header.jsp"></jsp:include>
		<jsp:include page="../common/menubar.jsp"></jsp:include>


		<div align="center">
			<h3 align="center">Contacts List</h3>
			<a href="showContacts.html">Refresh Contact List</a> <br> <br>
			<table id="contact_table" border="1">
				<thead>
					<tr>
						<th>Index</th>
						<th>Name</th>
						<th>Phone Number</th>
						<th>Email Id</th>
						<th colspan="2">Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${contactsList}" var="cntct" varStatus="loop">

						<tr>
							<td><c:out value="${loop.index + 1}" /></td>
							<td><c:out value="${cntct.name}" /></td>
							<td><c:out value="${cntct.phoneNumber}" /></td>
							<td><c:out value="${cntct.emailId}" /></td>
							<td><a
								href="editContact.html?contactId=${cntct.id}&contactName=${cntct.name}">edit</a>
							</td>
							<td><a
								href="deleteContact.html?contactId=${cntct.id}&contactName=${cntct.name}">delete</a>
							</td>

						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="center"><a href="addContact.html">Add
								New Contact</a></td>

					</tr>
				</tbody>
			</table>

		</div>


	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>


</body>
</html>