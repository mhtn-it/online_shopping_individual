package com.shopping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@Column
	private Long id;
	@Column
	private Long idUser;
	@Column
	private Date date;
	@Column
	private Long idItem;
	@Column
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Review(Long id, Long idUser, Date date, Long idItem, String content) {
		this.id = id;
		this.idUser = idUser;
		this.date = date;
		this.idItem = idItem;
		this.content = content;
	}

}
