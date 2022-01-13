package net.software.projects.carwash.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.software.projects.carwash.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

}
