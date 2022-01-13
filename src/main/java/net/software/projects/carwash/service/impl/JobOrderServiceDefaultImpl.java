package net.software.projects.carwash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.software.projects.carwash.model.JobOrder;
import net.software.projects.carwash.model.dao.JobOrderRepository;
import net.software.projects.carwash.service.JobOrderService;

@Service
public class JobOrderServiceDefaultImpl implements JobOrderService {

	@Autowired
	JobOrderRepository jobOrderRepository;

	@Override
	public List<JobOrder> findAll() {
		return jobOrderRepository.findAll();
	}

	@Override
	public JobOrder findOne(Long id) {
		return jobOrderRepository.findById(id).get();
	}

	@Override
	public void save(JobOrder jobOrder) {
		jobOrderRepository.save(jobOrder);
	}

	@Override
	public void removeOne(Long id) {
		jobOrderRepository.deleteById(id);
	}
	
	
	
}
