package com.shopping.model;

public class ItemCart {
	private Long id;
	private String name;
	private Long idItem;
	private Long idCart;
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
	public Long getIdCart() {
		return idCart;
	}
	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}
	
	public ItemCart(Long id, String name, Long idItem, Long idCart) {
		this.id = id;
		this.name = name;
		this.idItem = idItem;
		this.idCart = idCart;
	}
	
	
}
