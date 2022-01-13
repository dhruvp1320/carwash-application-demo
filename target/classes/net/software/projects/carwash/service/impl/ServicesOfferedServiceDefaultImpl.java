package net.software.projects.carwash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.projects.carwash.model.dao.ServiceRepository;
import net.software.projects.carwash.service.ServicesOfferedService;

@Service
public class ServicesOfferedServiceDefaultImpl implements ServicesOfferedService {

	@Autowired
	ServiceRepository serviceRepository;
	
	@Override
	public List<net.software.projects.carwash.model.Service> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	public net.software.projects.carwash.model.Service findOne(Long id) {
		return serviceRepository.findById(id).get();
	}

	@Override
	public void save(net.software.projects.carwash.model.Service service) {
		serviceRepository.save(service);
	}

	@Override
	public void removeOne(Long id) {
		serviceRepository.deleteById(id);
	}

}
