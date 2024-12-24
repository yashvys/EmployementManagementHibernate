package com.empmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empmanagement.entity.Employee;
import com.empmanagement.service.EmployeeService;

@WebServlet("/displayEmployees")
public class DisplayEmployeeServlet extends HttpServlet {
	private final EmployeeService service = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employee> employees = service.getAllEmployees();
		request.setAttribute("employees", employees);
		try {
			request.getRequestDispatcher("display.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}