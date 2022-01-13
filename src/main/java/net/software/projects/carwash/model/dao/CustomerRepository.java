package net.software.projects.carwash.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.software.projects.carwash.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
