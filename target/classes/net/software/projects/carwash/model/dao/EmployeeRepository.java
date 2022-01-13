package net.software.projects.carwash.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.software.projects.carwash.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
