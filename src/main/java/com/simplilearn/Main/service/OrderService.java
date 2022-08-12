package com.simplilearn.Main.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Main.entity.OrderEntity;
import com.simplilearn.Main.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public OrderEntity saveUser(OrderEntity entity) {
		return repo.save(entity);
	}
	public List<OrderEntity> getAllUsers(){
		return repo.findAll();
	}
	public OrderEntity getUserById(int id) {
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public OrderEntity updateUser(OrderEntity entity,int id)  {
		if(repo.findById(id).isPresent()) {
			OrderEntity old= repo.findById(id).get();
			old.setPaymentmode(entity.getPaymentmode());
			old.setId(entity.getId());

			Date date = new Date();
			System.out.println(date);
			
			old.setDate(date);
			
			
			return repo.save(old);
		}
		else
			return null;
	}
	
	public boolean deleteUser(int id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
