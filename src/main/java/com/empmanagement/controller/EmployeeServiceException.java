package com.empmanagement.controller;

/**
 * Custom exception class for handling errors in the EmployeeService layer.
 */
public class EmployeeServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for EmployeeServiceException with a message.
	 *
	 * @param message the exception message
	 */
	public EmployeeServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor for EmployeeServiceException with a message and a cause.
	 *
	 * @param message the exception message
	 * @param cause   the root cause of the exception
	 */
	public EmployeeServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}