package com.iftm.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.course.dto.OutputDTO;
import com.iftm.course.entities.Output;
import com.iftm.course.repositories.OutputRepository;
import com.iftm.course.services.exceptions.DatabaseException;
import com.iftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class OutputService {
	
	@Autowired
	private OutputRepository repository;
	
	public Page<OutputDTO> findAllPaged(Pageable pageable) {
		Page<Output> List = repository.findAll(pageable);
		return List.map(e -> new OutputDTO(e));		
	}
	
	/*public List<OutputDTO> findAll() {
		List<Output> List = repository.findAll();
		return List.stream().map(e -> new OutputDTO(e)).collect(Collectors.toList());		
	}*/
	
	public OutputDTO findById(Long id) {
		Optional<Output> obj = repository.findById(id);
		Output entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new OutputDTO(entity);
	}
	
	@Transactional
	public OutputDTO insert(OutputDTO dto) {
		Output entity = dto.toEntity();
		entity = repository.save(entity);
		return new OutputDTO(entity);
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
	public OutputDTO update(Long id, OutputDTO dto) {
		try {
			Output entity = repository.getOne(id);
			updateData(entity, dto);
			entity =  repository.save(entity);
			return new OutputDTO(entity);
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Output entity, OutputDTO dto) {
		entity.setDescricao(dto.getDescricao());
		entity.setData(dto.getData());
		entity.setValor(dto.getValor());		
	}

}
