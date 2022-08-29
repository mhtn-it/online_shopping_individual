package com.shopping.model;

import java.util.Date;

public class Cart {
	private Long id;
	private Date date;
	private Long idUser;
	private Integer count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Cart(Long id, Date date, Long idUser, Integer count) {
		this.id = id;
		this.date = date;
		this.idUser = idUser;
		this.count = count;
	}
	
	
} 
