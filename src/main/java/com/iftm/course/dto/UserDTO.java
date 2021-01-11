package com.iftm.course.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iftm.course.entities.User;
import com.iftm.course.services.exceptions.validation.UserUpdateValid;

@UserUpdateValid
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date data_nascimento;
	private String email;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, Date data_nascimento, String email) {
		super();
		this.id = id;
		this.name = name;
		this.data_nascimento = data_nascimento;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.data_nascimento = entity.getData_nascimento();
		this.email = entity.getEmail();
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User toEntity() {
		return new User(id, name, data_nascimento, email, null);
	}
	

}
