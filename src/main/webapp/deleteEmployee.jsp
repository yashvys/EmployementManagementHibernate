<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="container">
		<h2>Delete Employee</h2>
		<form action="deleteEmployee" method="post">
			<label for="id">Employee ID:</label> <input type="number" id="id"
				name="id" required> <input type="submit"
				value="Delete Employee">
		</form>
		<div class="home-link-container">
			<a class="home-link" href="welcome.jsp">Home</a>
		</div>
	</div>
</body>
</html>