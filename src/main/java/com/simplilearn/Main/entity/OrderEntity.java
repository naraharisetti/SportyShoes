package com.simplilearn.Main.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

//import org.springframework.data.jpa.repository.Temporal;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
    @Temporal(value=TemporalType.DATE)
	private Date date;
	
	private String paymentmode;
	
	@ManyToOne
	private UserEntity user_foreign;
	

	@ManyToOne
	private OrderEntity cate_foreign;	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserEntity getUser_foreign() {
		return user_foreign;
	}
	public void setUser_foreign(UserEntity user_foreign) {
		this.user_foreign = user_foreign;
	}
	public OrderEntity getCate_foreign() {
		return cate_foreign;
	}
	public void setCate_foreign(OrderEntity cate_foreign) {
		this.cate_foreign = cate_foreign;
	}


	
	

	
	
}
