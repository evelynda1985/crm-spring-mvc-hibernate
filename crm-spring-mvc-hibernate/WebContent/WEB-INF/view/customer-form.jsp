<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Save customer</title>
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css">
			  
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
			  
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/form_style.css">
	</head>
	
	<body>

			<div class="header">
				<h1>CRM - Customer Relationship Manager</h1>
			</div>

		
		<div >
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" method="Post">
			
			<!-- need to associate the data with the customer id, otherwise we will lose the track of the customer -->
			<form:hidden path="id"/>
			
				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						
												<tr>
						<td><label>SSN:</label></td>
							<td><form:input path="socSecurityNum"/></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="save" id="add-button"/></td>
						</tr>
						
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/customer/list"> Back to the list </a>
			</p>			
			
		</div>
	
		
	</body>
</html>