package com.empmanagement.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.entity.Employee;
import com.empmanagement.service.EmployeeService;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

	private final EmployeeService service = new EmployeeService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// Parse parameters from the request
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			double salary = Double.parseDouble(request.getParameter("salary"));

			// Update employee using the service
			service.updateEmployee(new Employee(id, name, age, email, salary));

			// Redirect to welcome.jsp
			response.sendRedirect("welcome.jsp");

		} catch (NumberFormatException e) {
			// Handle invalid input format for ID, age, or salary
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid format for ID, age, or salary.");
			} catch (IOException ioException) {
				// Handle the IOException thrown by sendError
				response.getWriter().write("Error occurred while handling invalid input format.");
			}

		} catch (IOException e) {
			// Handle IOException from sendRedirect
			try {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred while redirecting.");
			} catch (IOException ioException) {
				// Handle the IOException thrown by sendError
				response.getWriter().write("Error occurred while sending redirect.");
			}
		}
	}
}