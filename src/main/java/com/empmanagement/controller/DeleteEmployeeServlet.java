package com.empmanagement.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.service.EmployeeService;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

	private final EmployeeService service = new EmployeeService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			// Parse the ID parameter from the request
			int id = Integer.parseInt(request.getParameter("id"));

			// Call the service method to delete the employee
			service.deleteEmployee(id);

			// Redirect to the display page
			safeRedirect(response, "displayEmployees");

		} catch (NumberFormatException e) {
			// Handle invalid ID format
			sendErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, "Invalid employee ID format.");
		}
	}

	/**
	 * Safely redirects the response to the given URL.
	 *
	 * @param response The HttpServletResponse object
	 * @param url      The URL to redirect to
	 */
	private void safeRedirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// Handle redirection error
			writeErrorMessage(response, "Error occurred while redirecting: " + e.getMessage());
		}
	}

	/**
	 * Sends an error response with the specified status code and message.
	 *
	 * @param response   The HttpServletResponse object
	 * @param statusCode The HTTP status code
	 * @param message    The error message to send
	 */
	private void sendErrorResponse(HttpServletResponse response, int statusCode, String message) {
		try {
			response.sendError(statusCode, message);
		} catch (IOException e) {
			// Handle error while sending the error response
			writeErrorMessage(response, "Error occurred while sending error response: " + e.getMessage());
		}
	}

	/**
	 * Writes a generic error message to the response.
	 *
	 * @param response The HttpServletResponse object
	 * @param message  The error message to write
	 */
	private void writeErrorMessage(HttpServletResponse response, String message) {
		try {
			response.getWriter().write(message);
		} catch (IOException e) {
			// Log the failure to write the error message
			e.printStackTrace();
		}
	}
}