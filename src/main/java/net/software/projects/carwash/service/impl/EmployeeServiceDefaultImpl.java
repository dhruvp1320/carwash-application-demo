package net.software.projects.carwash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.projects.carwash.model.Employee;
import net.software.projects.carwash.model.dao.EmployeeRepository;
import net.software.projects.carwash.service.EmployeeService;

@Service
public class EmployeeServiceDefaultImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findOne(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void removeOne(Long id) {
		employeeRepository.deleteById(id);
	}
}
