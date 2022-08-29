package com.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemBill")
public class ItemBill {
	@Id
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private Long idItem;
	@Column
	private Long idBill;

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

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public long getIdBill() {
		return idBill;
	}

	public void setIdBill(long idBill) {
		this.idBill = idBill;
	}

	public ItemBill(Long id, String name, Long idItem, long idBill) {
		this.id = id;
		this.name = name;
		this.idItem = idItem;
		this.idBill = idBill;
	}

}
