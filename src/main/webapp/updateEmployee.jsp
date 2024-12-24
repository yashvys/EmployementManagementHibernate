<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="container">
		<h2>Update Employee</h2>
		<form action="updateEmployee" method="post">
			<label for="id">ID:</label> <input type="number" id="id" name="id"
				required><br> <label for="name">Name:</label> <input
				type="text" id="name" name="name" required><br> <label
				for="age">Age:</label> <input type="number" id="age" name="age"
				required><br> <label for="email">Email:</label> <input
				type="email" id="email" name="email" required><br> <label
				for="salary">Salary:</label> <input type="number" id="salary"
				name="salary" step="0.01" required><br> <input
				type="submit" value="Update Employee">
		</form>
		<div class="home-link-container">
			<a class="home-link" href="welcome.jsp">Home</a>
		</div>
	</div>
</body>
</html>