package com.simplilearn.Main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.Main.entity.CateEntity;

@Repository
public interface CateRepository extends JpaRepository<CateEntity, Integer> {

	
}
