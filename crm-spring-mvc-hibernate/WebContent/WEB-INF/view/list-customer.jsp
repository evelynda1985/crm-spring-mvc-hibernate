<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>List Customer</title>
		
		<!-- reference style sheet css -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/customer_style.css"/>
		
	</head>
	
	<body>
	
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	
		<div class="made-with-love">
		
		<!-- put new button: add customer -->
		<!-- call spring controller -->
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormAdd'; return false;" 
				class="add-button"/> 
		</div>
		
			<!-- add html table here -->
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Security Social Number</th>
					<th>Action</th>
				</tr>
			</table>
		</div >
		
		<div class="tbl-content">
			<table>	
				<!-- loop over and print customers -->
				<c:forEach var="tempCustomer" items="${Customers}">
				
				<!-- update link by customer id -->
				<c:url var="updateLink" value="/customer/showFormUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
				<!-- delete link by customer id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName}</td>
						<td> ${tempCustomer.lastName}</td>
						<td> ${tempCustomer.socSecurityNum}</td>
						
						<!-- display the update link -->
						<td>  
							<a href="${updateLink}"> Update </a>
							|
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure that you want to delete this customer?'))) return false"> Delete </a>
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>

	
	<!-- template by: -->
	<div class="made-with-love">
		  Made with
		  <a target="_blank" href="https://codepen.io/nikhil8krishnan">Nikhil Krishnan</a>
	</div>
	
	
	
	</body>
</html>