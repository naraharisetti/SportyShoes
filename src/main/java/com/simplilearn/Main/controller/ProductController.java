package com.simplilearn.Main.controller;

import java.util.ArrayList;
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

import com.simplilearn.Main.entity.*;
import com.simplilearn.Main.service.*;

@RestController
@RequestMapping("MainPage/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("")
	public ResponseEntity<Object> addUser(@RequestBody ProductEntity entity){
		ProductEntity resp=service.saveUser(entity);
		if(resp!=null)
			return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while inserting a data",
					HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("")
	public List<ProductTable> getAllUsers(){
		List<ProductEntity> pEntityList = new ArrayList<>();

		List<ProductTable> producttable = new ArrayList<>(); 

		pEntityList = service.getAllUsers(); 
		System.out.println("list size :"+pEntityList.size());

		for (int i = 0; i < pEntityList.size(); i++) {

		
			ProductTable ptable = new ProductTable();
			ptable.setId(pEntityList.get(i).getId());
			ptable.setDescrip(pEntityList.get(i).getDescrip());
			ptable.setName(pEntityList.get(i).getName());
			ptable.setPrice(pEntityList.get(i).getPrice());
			ptable.setPro_id(pEntityList.get(i).getPro_id());
			ptable.setCate_id(pEntityList.get(i).getCate_foreign().getId());

			producttable.add(ptable);
		}

		return producttable;
		//		return service.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") int id){
		ProductEntity obj= service.getUserById(id);
		ProductTable ptable = new ProductTable();
		if(obj!=null) {
			
			ptable.setId(obj.getId());
			ptable.setDescrip(obj.getDescrip());
			ptable.setName(obj.getName());
			ptable.setPrice(obj.getPrice());
			ptable.setPro_id(obj.getPro_id());
			ptable.setCate_id(obj.getCate_foreign().getId());
			return new ResponseEntity<Object>(ptable,HttpStatus.FOUND);
		}
		else
			return new ResponseEntity<Object>("No user available with this id",
					HttpStatus.NOT_FOUND);
	}
	
	


	@GetMapping("/hello")
	public String myMethod() {
		return "Hello from Product";
	}
}









