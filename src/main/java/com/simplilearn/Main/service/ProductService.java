package com.simplilearn.Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Main.entity.ProductEntity;
import com.simplilearn.Main.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public ProductEntity saveUser(ProductEntity entity) {
		return repo.save(entity);
	}
	public List<ProductEntity> getAllUsers(){
		return   repo.findAll();
	}
	public ProductEntity getUserById(int id) {
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public ProductEntity updateUser(ProductEntity entity,int id) {
		if(repo.findById(id).isPresent()) {
			ProductEntity old= repo.findById(id).get();
			old.setName(entity.getName());
			old.setPrice(entity.getPrice());

			old.setDescrip(entity.getDescrip());
			
			System.out.println(entity.getCate_foreign());
			old.setCate_foreign(entity.getCate_foreign());
			
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
