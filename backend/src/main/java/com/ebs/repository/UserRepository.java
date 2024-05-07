package com.ebs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebs.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select userId from User order by userId")
	List<Integer> getIdList();
}
