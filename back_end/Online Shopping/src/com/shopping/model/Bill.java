package com.shopping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "getSum", query = "select sum(total) from Bill"),
		@NamedQuery(name = "getSumOfUser", query = "select sum(total) from Employee where idUser=:idUser") })

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private Long idUser;
	@Column
	private String address;
	@Column
	private String phoneNumber;
	@Column
	private Long total;
	@Column
	private Date date;
	@Column
	private Integer status;

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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Bill(Long id, String name, Long idUser, String address, String phoneNumber, Long total, Date date,
			Integer status) {
		this.id = id;
		this.name = name;
		this.idUser = idUser;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.total = total;
		this.date = date;
		this.status = status;
	}

}
