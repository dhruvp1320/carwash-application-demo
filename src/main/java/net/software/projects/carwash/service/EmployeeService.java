package net.software.projects.carwash.service;

import java.util.List;

import net.software.projects.carwash.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

	Employee findOne(Long id);

	void save(Employee employee);

	void removeOne(Long id);
}
