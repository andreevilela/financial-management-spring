package com.iftm.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.course.dto.InputDTO;
import com.iftm.course.entities.Input;
import com.iftm.course.repositories.InputRepository;
import com.iftm.course.services.exceptions.DatabaseException;
import com.iftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class InputService {
	
	@Autowired
	private InputRepository repository;
	
	public List<InputDTO> findAll() {
		List<Input> List = repository.findAll();
		return List.stream().map(e -> new InputDTO(e)).collect(Collectors.toList());		
	}
	
	public InputDTO findById(Long id) {
		Optional<Input> obj = repository.findById(id);
		Input entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new InputDTO(entity);
	}
	
	@Transactional
	public InputDTO insert(InputDTO dto) {
		Input entity = dto.toEntity();
		entity = repository.save(entity);
		return new InputDTO(entity);
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
	public InputDTO update(Long id, InputDTO dto) {
		try {
			Input entity = repository.getOne(id);
			updateData(entity, dto);
			entity =  repository.save(entity);
			return new InputDTO(entity);
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Input entity, InputDTO dto) {
		entity.setDescricao(dto.getDescricao());
		entity.setData(dto.getData());
		entity.setValor(dto.getValor());		
	}

}
