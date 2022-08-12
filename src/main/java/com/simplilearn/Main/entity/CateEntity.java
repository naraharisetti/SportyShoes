package com.simplilearn.Main.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class CateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cat_id;
	private String name;
	
	
	@OneToMany(mappedBy = "cate_foreign")
	private List<ProductEntity> productentity = new ArrayList<>();
	
	@OneToMany(mappedBy = "cate_foreign")
	private List<OrderEntity> orderentity = new ArrayList<>();
	

	
	
	public String getName() {
		return name;
	}
	
	
	public int getCat_id() {
		return cat_id;
	}


	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}


	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public void setProductentity(List<ProductEntity> productentity) {
		this.productentity = productentity;
	}
	public List<ProductEntity> getProductentity() {
		return productentity;
	}
	
	
	public void addProductentity(ProductEntity productentity1) {
		this.productentity.add(productentity1);
	}
	

	public void removeProductentity(ProductEntity productentity1) {
		this.productentity.remove(productentity1);
	}


	public List<OrderEntity> getOrderentity() {
		return orderentity;
	}


	public void setOrderentity(List<OrderEntity> orderentity) {
		this.orderentity = orderentity;
	}


	
	
	
}
