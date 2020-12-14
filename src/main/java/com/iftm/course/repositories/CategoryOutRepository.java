package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.CategoryOut;

public interface CategoryOutRepository extends JpaRepository<CategoryOut, Long> {
	
	
}
