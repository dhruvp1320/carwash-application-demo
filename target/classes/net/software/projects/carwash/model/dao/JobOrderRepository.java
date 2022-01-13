package net.software.projects.carwash.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.software.projects.carwash.model.JobOrder;

public interface JobOrderRepository extends JpaRepository<JobOrder, Long>{

}
