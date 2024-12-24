<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="container">
		<h2>Employee List</h2>
		<c:if test="${not empty employees}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Email</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employees}">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.age}</td>
							<td>${employee.email}</td>
							<td>${employee.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty employees}">
			<p>No employees found.</p>
		</c:if>
		<div class="home-link-container">
			<a class="home-link" href="welcome.jsp">Home</a>
		</div>
	</div>
</body>
</html>