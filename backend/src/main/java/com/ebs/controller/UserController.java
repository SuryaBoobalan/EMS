package com.ebs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ebs.exception.UserNotFoundException;

import com.ebs.model.User;

import com.ebs.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
	

	@Autowired
	UserRepository urepo;
	
	@PostMapping("/User")
	public String doInsert(@RequestBody User u) {
		urepo.save(u);
		return "User Saved Successfully";
	}
	
	@GetMapping("/User")
	public List<User> doFind() {
		return urepo.findAll();
	}

	@GetMapping("/User/{userId}")
	public Optional<User> doFindById(@PathVariable int userId) {
		return urepo.findById(userId);
	}
	
	@PutMapping("/Tariff/{userId}")
	User doUpdate(@RequestBody User v, @PathVariable int userId){
		return urepo.findById(userId)
				.map(user -> {
						user.setUserName(v.getUserName());
						user.setDivision(v.getDivision());
						user.setCalc(v.getCalc());
						return urepo.save(user);
		}).orElseThrow(()-> new UserNotFoundException(userId));
		
			
		}
	
	@GetMapping("/Userid")
	public List<Integer> doGetId(){
		System.out.println(urepo.getIdList());
		return urepo.getIdList();
		
	}
	
	@DeleteMapping("/User/{userId}")
	public String doDelete(@PathVariable int userId) {
		
	 urepo.deleteById(userId);
	 return "User Deleted Successfully";

	}
}
