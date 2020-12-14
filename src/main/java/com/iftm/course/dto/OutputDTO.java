package com.iftm.course.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iftm.course.entities.CategoryOut;
import com.iftm.course.entities.Output;
import com.iftm.course.entities.User;

public class OutputDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date data;
	private double valor;
	private Long userId;
	private String userName;
	private Date userData_nascimento;
	private String userEmail;
	private Long categoryOutId;
	private String categoryOutName;
	
	public OutputDTO() {
	}

	public OutputDTO(Long id, String descricao, Date data, double valor, Long userId, String userName, Date userData_nascimento, String userEmail, Long categoryOutId, String categoryOutName) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.userId = userId;
		this.userName = userName;
		this.userData_nascimento = userData_nascimento;
		this.userEmail = userEmail;
		this.categoryOutId = categoryOutId;
		this.categoryOutName = categoryOutName;
	}
	
	public OutputDTO(Output entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.data = entity.getData();
		this.valor = entity.getValor();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getName();
		this.userData_nascimento = entity.getUser().getData_nascimento();
		this.userEmail = entity.getUser().getEmail();
		this.categoryOutId = entity.getCategoryOut().getId();
		this.categoryOutName = entity.getCategoryOut().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserData_nascimento() {
		return userData_nascimento;
	}

	public void setUserData_nascimento(Date userData_nascimento) {
		this.userData_nascimento = userData_nascimento;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getCategoryOutId() {
		return categoryOutId;
	}

	public void setCategoryOutId(Long categoryOutId) {
		this.categoryOutId = categoryOutId;
	}

	public String getCategoryOutName() {
		return categoryOutName;
	}

	public void setCategoryOutName(String categoryOutName) {
		this.categoryOutName = categoryOutName;
	}

	public Output toEntity() {
		User user = new User(userId, userName, userData_nascimento, userEmail, null);
		CategoryOut categoryOut = new CategoryOut(categoryOutId, categoryOutName);
		return new Output(id, descricao, data, valor, user, categoryOut);
	}
	

}
