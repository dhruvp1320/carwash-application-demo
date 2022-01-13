package net.software.projects.carwash.service;

import java.util.List;

import net.software.projects.carwash.model.Service;

public interface ServicesOfferedService {

	List<Service> findAll();

	Service findOne(Long id);

	void save(Service service);

	void removeOne(Long id);
	
}
