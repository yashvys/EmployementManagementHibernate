package com.empmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.entity.Employee;
import com.empmanagement.service.EmployeeService;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final EmployeeService service = new EmployeeService(); // Initialize the service

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Parse parameters
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			double salary = Double.parseDouble(request.getParameter("salary"));

			// Add employee using the service layer
			service.addEmployee(new Employee(id, name, age, email, salary));

			// Redirect to welcome.jsp
			response.sendRedirect("welcome.jsp");

		} catch (NumberFormatException e) {
			// Handle invalid input (e.g., non-numeric values for ID, age, or salary)
			sendErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, "Invalid input format: " + e.getMessage());
		} catch (EmployeeServiceException e) {
			// Handle custom service exception
			sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"Error while adding employee: " + e.getMessage());
		} catch (IOException e) {
			// Handle IOException from sendRedirect or sendError
			sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"I/O error occurred: " + e.getMessage());
		}
	}

	/**
	 * Helper method to send error responses
	 *
	 * @param response   HttpServletResponse object
	 * @param statusCode HTTP status code
	 * @param message    Error message
	 */
	private void sendErrorResponse(HttpServletResponse response, int statusCode, String message) {
		try {
			response.setStatus(statusCode);
			response.getWriter().write(message);
		} catch (IOException e) {
			// Log an error if we fail to write the response
			e.printStackTrace();
		}
	}
}