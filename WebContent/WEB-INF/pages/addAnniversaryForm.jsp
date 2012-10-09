<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/styles/error.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd",
			altField : "#alternate",
			altFormat : "DD, d MM, yy",
			showButtonPanel : true,
			showOtherMonths : true,
			selectOtherMonths : true,
			showOn : "button",
			buttonImage : "resources/images/calendar.gif",
			buttonImageOnly : true,
			showAnim : "slide"
		});
	});
</script>


</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/menubar.jsp"></jsp:include>

	<div id="anniversaryForm" align="center">
		<h2>Add Anniversary</h2>
		<form:form method="POST" commandName="anniversary">
			<table>
				<tr>
					<td>Title :</td>
					<td><form:select path="title">
							<form:option value="Birthday">Birthday</form:option>
							<form:option value="Other">Other</form:option>
						</form:select></td>

				</tr>
				<tr>
					<td>People :</td>
					<td><form:input path="people" /></td>
					<td><form:errors path="people" cssClass="error" /></td>

				</tr>
				<tr>
					<td>Date :</td>
					<td><form:input id="datepicker" path="date" /></td>
					<td><form:errors path="date" cssClass="error" /></td>
					
				</tr>
				<tr>
					<td></td>
					<td><input type="text" id="alternate" readonly="readonly"
						size="30" /></td>
				</tr>

				<tr>
					<td>Repeat :</td>
					<td><form:select path="repeatCycle">
							<form:option value="y">Yearly</form:option>
							<form:option value="m">Monthly</form:option>
							<form:option value="w">Weekly</form:option>
						</form:select></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add" /> <input type="button"
						value="Cancel"
						onClick="window.location.href='importantDates.html'" /></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>