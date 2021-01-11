package com.iftm.course.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iftm.course.entities.User;
import com.iftm.course.services.exceptions.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 5, max = 80, message = "Length must be between 5 and 80")
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date data_nascimento;
	
	@NotEmpty(message = "can't be empty")
	@Email
	private String email;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 6, max = 20, message = "Length must be between 6 and 20")
	private String password;
	
	
	public UserInsertDTO() {
	}

	public UserInsertDTO(Long id, String name, Date data_nascimento, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.password = password;
	}
	
	public UserInsertDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.data_nascimento = entity.getData_nascimento();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User toEntity() {
		return new User(id, name, data_nascimento, email, password);
	}

}
