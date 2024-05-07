package com.ebs.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.model.Calculated;
import com.ebs.repository.CalulatedRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CalculatedController {
	
	@Autowired
	CalulatedRepository crepo;
	
	@PostMapping("/Calc")
	public String doInsert(@RequestBody Calculated c) {
		crepo.save(c);
		return "Object Saved";
	}
	
	@GetMapping("/Calc")
	public List<Calculated> doFind() {
		return crepo.findAll();
	}


}
