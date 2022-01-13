package net.software.projects.carwash.service;

import java.util.List;

import net.software.projects.carwash.model.JobOrder;

public interface JobOrderService {
	
	List<JobOrder> findAll();

	JobOrder findOne(Long id);

	void save(JobOrder jobOrder);

	void removeOne(Long id);
}
