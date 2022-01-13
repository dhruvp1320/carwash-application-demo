package net.software.projects.carwash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.projects.carwash.model.Customer;
import net.software.projects.carwash.model.dao.CustomerRepository;
import net.software.projects.carwash.service.CustomerService;

@Service
public class CustomerServiceDefaultImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findOne(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void removeOne(Long id) {
		customerRepository.deleteById(id);
	}
}
