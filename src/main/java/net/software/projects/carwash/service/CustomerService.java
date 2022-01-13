package net.software.projects.carwash.service;

import java.util.List;

import net.software.projects.carwash.model.Customer;

public interface CustomerService {
	
	List<Customer> findAll();

	Customer findOne(Long id);

	void save(Customer customer);

	void removeOne(Long id);
}
