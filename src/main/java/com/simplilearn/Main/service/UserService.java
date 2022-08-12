package com.simplilearn.Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Main.entity.UserEntity;
import com.simplilearn.Main.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public UserEntity saveUser(UserEntity entity) {
		return repo.save(entity);
	}
	public List<UserEntity> getAllUsers(){
		return repo.findAll();
	}
	public UserEntity getUserById(int id) {
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public UserEntity updateUser(UserEntity entity,int id) {
		if(repo.findById(id).isPresent()) {
			UserEntity old= repo.findById(id).get();
			old.setName(entity.getName());
			old.setEmail(entity.getEmail());
			old.setPhone(entity.getPhone());
			old.setPassword(entity.getPassword());
			old.setUser_id(entity.getUser_id());
			
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
