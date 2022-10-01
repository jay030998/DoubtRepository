<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h3>Customer Relationship Management</h3>
		<hr>
	</div>
	
	<form action="/CustomerRelationshipManagement/customers/list" class="form-inline">
			
	</form>
	
	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${Customers}" var="tempCustomer">
				<tr>
					<td><c:out value="${tempStudent.firstName }" /></td>
					<td><c:out value="${tempStudent.lastName }" /></td>
					<td><c:out value="${tempStudent.email }" /></td>
					
				</tr>
			</c:forEach>
		</tbody>	
			
	</table>
</body>
</html>