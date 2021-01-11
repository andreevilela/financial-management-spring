package com.iftm.course.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.iftm.course.entities.Category;

public class CategoryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 4, max = 40, message = "Length must be between 4 and 40")
	private String name;
	
	public CategoryDTO() {

	}

	public CategoryDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoryDTO(Category entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category toEntity() {
		return new Category(id, name);
	}
	
	

}
