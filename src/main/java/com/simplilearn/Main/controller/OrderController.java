package com.simplilearn.Main.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.Main.entity.OrderEntity;
import com.simplilearn.Main.entity.OrderTable;
import com.simplilearn.Main.entity.ProductEntity;
import com.simplilearn.Main.entity.ProductTable;
import com.simplilearn.Main.service.OrderService;

//import java.sql.ResultSet;

@RestController
@RequestMapping("/MainPage/Orders")
public class OrderController {

	//	private static final ResultSet ResultSet = null;
	@Autowired
	private OrderService service;

	@PostMapping("")
	public ResponseEntity<Object> addUser(@RequestBody OrderEntity entity){

		Date date = new Date();
		entity.setDate(date);

		OrderEntity resp=service.saveUser(entity);
		if(resp!=null)
			return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while inserting a data",
					HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@GetMapping("")
	public List<OrderTable> getAllUsers(){

		List<OrderEntity> oEntityList = new ArrayList<>();

		List<OrderTable> ordertable = new ArrayList<>(); 

		oEntityList = service.getAllUsers(); 

		for (int i = 0; i < oEntityList.size(); i++) {

			OrderTable otable = new OrderTable();
			otable.setId(oEntityList.get(i).getId());
			otable.setDate(oEntityList.get(i).getDate());
			otable.setPaymentmode(oEntityList.get(i).getPaymentmode());
			otable.setCate_id(oEntityList.get(i).getCate_foreign().getId());
			otable.setUser_id(oEntityList.get(i).getUser_foreign().getId());

			ordertable.add(otable);
		}

		return ordertable;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id){
		OrderEntity obj= service.getUserById(id);
		OrderTable otable = new OrderTable();
		if(obj!=null) {
			otable.setId(obj.getId());
			otable.setDate(obj.getDate());
			otable.setPaymentmode(obj.getPaymentmode());
			otable.setCate_id(obj.getCate_foreign().getId());
			otable.setUser_id(obj.getUser_foreign().getId());

			return new ResponseEntity<Object>(otable,HttpStatus.FOUND);
		}
		else
			return new ResponseEntity<Object>("No user available with this id",
					HttpStatus.NOT_FOUND);			
	}

	@GetMapping("/bycategory/{id}")
	public List<OrderTable> getAllUsers(@PathVariable int id){

		List<OrderEntity> oEntityList = new ArrayList<>();

		List<OrderTable> ordertable = new ArrayList<>(); 

		oEntityList = service.getAllUsers(); 

		for (int i = 0; i < oEntityList.size(); i++) {			
			if (id == oEntityList.get(i).getCate_foreign().getId() ) {
				System.out.println("input " + id + " cate_id " + oEntityList.get(i).getCate_foreign().getId());
				System.out.println("id " + oEntityList.get(i).getId());
				
				OrderTable otable = new OrderTable();

				otable.setId(oEntityList.get(i).getId());
				otable.setDate(oEntityList.get(i).getDate());
				otable.setPaymentmode(oEntityList.get(i).getPaymentmode());
				otable.setCate_id(oEntityList.get(i).getCate_foreign().getId());
				otable.setUser_id(oEntityList.get(i).getUser_foreign().getId());
				ordertable.add(otable);
				
			}	
		}
		return ordertable;
	}
	
	@GetMapping("/bydate/{id}")
	public List<OrderTable> getAllUsersDate(@PathVariable String id) throws ParseException{

		List<OrderEntity> oEntityList = new ArrayList<>();

		List<OrderTable> ordertable = new ArrayList<>(); 

		oEntityList = service.getAllUsers(); 
		

		for (int i = 0; i < oEntityList.size(); i++) {	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString=sdf.format(oEntityList.get(i).getDate()); 

			if (dateString.equals(id)) {

				
				OrderTable otable = new OrderTable();

				otable.setId(oEntityList.get(i).getId());
				otable.setDate(oEntityList.get(i).getDate());
				otable.setPaymentmode(oEntityList.get(i).getPaymentmode());
				otable.setCate_id(oEntityList.get(i).getCate_foreign().getId());
				otable.setUser_id(oEntityList.get(i).getUser_foreign().getId());
				ordertable.add(otable);
				
			}	
		}
		return ordertable;
	}

	@GetMapping("/hello")
	public String myMethod() {
		return "Hello from Orders";
	}
}
