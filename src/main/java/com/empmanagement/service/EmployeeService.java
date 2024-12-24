package com.empmanagement.service;

import com.empmanagement.controller.EmployeeServiceException;
import com.empmanagement.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService {

	private final EntityManagerFactory emf;

	public EmployeeService() {
		emf = Persistence.createEntityManagerFactory("yash");
	}

	public void addEmployee(Employee employee) throws EmployeeServiceException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null; // Changed to EntityTransaction
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(employee);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw new EmployeeServiceException("Failed to add employee: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	public List<Employee> getAllEmployees() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new EmployeeServiceException("Failed to retrieve employees: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	public void updateEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null; // Changed to EntityTransaction

		try {
			transaction = em.getTransaction();
			transaction.begin();
			Employee emp = em.find(Employee.class, employee.getId());
			if (emp != null) {
				emp.setName(employee.getName());
				emp.setAge(employee.getAge());
				emp.setEmail(employee.getEmail());
				emp.setSalary(employee.getSalary());

				em.merge(emp);
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw new EmployeeServiceException("Failed to update employee : " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

	public void deleteEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = null; // Changed to EntityTransaction
		try {
			transaction = em.getTransaction();
			transaction.begin();
			Employee employee = em.find(Employee.class, id);
			if (employee != null) {
				em.remove(employee);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			throw new EmployeeServiceException("Failed to delete employee: " + e.getMessage(), e);
		} finally {
			em.close();
		}
	}

}