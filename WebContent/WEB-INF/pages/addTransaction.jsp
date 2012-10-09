<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
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

	<div id="container" align="center">

		<div id="transaction_form">
			<form:form commandName="transaction" method="POST">
				<table>
					<tr>
						<td>I owe :</td>
						<td><form:select path="contactId">
							<c:forEach items="${contactsList}" var="cntct" varStatus="loop">
								<form:option value="${cntct.id}" >${cntct.name}</form:option>	
							</c:forEach>
						</form:select>
						
						</td>
					</tr>	
					<tr>	
						<td>Rupees :</td>
						<td><form:input path="amount" value=""/></td>
						<td><form:errors path="amount" cssClass="error" /></td>
					</tr>
					<tr>
						<td>for :</td>
						<td><form:input path="description" /></td>
						<td><form:errors path="description" cssClass="error" /></td>
					</tr>
					<tr>
						<td>On date :</td>
						<td><form:input id="datepicker" path="date" /></td>
						<td><form:errors path="date" cssClass="error" /></td>

					</tr>
					<tr>
					<td><input type="submit" value="Add" /></td>
					</tr>




				</table>
			</form:form>




		</div>


		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>



</body>
</html>