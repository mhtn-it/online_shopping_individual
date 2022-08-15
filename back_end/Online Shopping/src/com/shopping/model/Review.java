package com.shopping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
	@Id
	@Column
	private Long id;
	@Column
	private Long id_user;
	@Column
	private Date date;
	@Column
	private Long id_item;
	@Column
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Review(Long id, Long id_user, Date date, Long id_item, String content) {
		this.id = id;
		this.id_user = id_user;
		this.date = date;
		this.id_item = id_item;
		this.content = content;
	}

}
