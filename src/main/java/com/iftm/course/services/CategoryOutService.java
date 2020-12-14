package com.iftm.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.course.dto.CategoryOutDTO;
import com.iftm.course.entities.CategoryOut;
import com.iftm.course.repositories.CategoryOutRepository;
import com.iftm.course.services.exceptions.DatabaseException;
import com.iftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryOutService {
	
	@Autowired
	private CategoryOutRepository repository;
	
	public List<CategoryOutDTO> findAll() {
		List<CategoryOut> list = repository.findAll();
		return list.stream().map(e -> new CategoryOutDTO(e)).collect(Collectors.toList());
		
	}
	
	public CategoryOutDTO findById(Long id) {
		Optional<CategoryOut> obj = repository.findById(id);
		CategoryOut entity =  obj.get();
		return new CategoryOutDTO(entity);
	}
	
	public CategoryOutDTO insert(CategoryOutDTO dto) {
		CategoryOut entity = dto.toEntity();
		entity =  repository.save(entity);
		return new CategoryOutDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	@Transactional
	public CategoryOutDTO update(Long id, CategoryOutDTO dto) {
		try {
			CategoryOut entity = repository.getOne(id);
			updateData(entity, dto);
			entity =  repository.save(entity);
			return new CategoryOutDTO(entity);
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(CategoryOut entity, CategoryOutDTO dto) {
		entity.setName(dto.getName());	
	}

}
