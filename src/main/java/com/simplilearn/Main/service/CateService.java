package com.simplilearn.Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Main.entity.CateEntity;
import com.simplilearn.Main.repo.CateRepository;

@Service
public class CateService {

	@Autowired
	private CateRepository repo;
	
	public CateEntity saveUser(CateEntity entity) {
		return repo.save(entity);
	}
	public List<CateEntity> getAllUsers(){
		return repo.findAll();
	}
	public CateEntity getUserById(int id) {
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public CateEntity updateUser(CateEntity entity,int id) {
		if(repo.findById(id).isPresent()) {
			CateEntity old= repo.findById(id).get();
			old.setName(entity.getName());
			old.setProductentity(entity.getProductentity());
			old.setCat_id(entity.getCat_id());
			
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
