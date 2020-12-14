package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Input;

public interface InputRepository extends JpaRepository<Input, Long> {
	
	
}
