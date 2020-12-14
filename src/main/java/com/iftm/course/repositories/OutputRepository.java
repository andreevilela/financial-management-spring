package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Output;

public interface OutputRepository extends JpaRepository<Output, Long> {
	
	
}
