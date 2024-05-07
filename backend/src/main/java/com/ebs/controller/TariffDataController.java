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

import com.ebs.exception.TariffNotFoundException;
import com.ebs.model.TariffData;
import com.ebs.repository.TariffRepository;


@RestController
@CrossOrigin("http://localhost:3000/")
public class TariffDataController {
	
	@Autowired
	TariffRepository trepo;
	
	@PostMapping("/Tariff")
	public String doInsert(@RequestBody TariffData td) {
		trepo.save(td);
		return "Tariff Saved";
	}
	
	@GetMapping("/Tariff")
	public List<TariffData> doFind() {
		return trepo.findAll();
	}

	@GetMapping("/Tariff/{tariffid}")
	public Optional<TariffData> doFindById(@PathVariable int tariffid) {
		return trepo.findById(tariffid);
	}
	
	@PutMapping("/Tariff/{tariffid}")
	TariffData doUpdate(@RequestBody TariffData v, @PathVariable int tariffid){
		return trepo.findById(tariffid)
				.map(tariff -> {
						tariff.setTariffName(v.getTariffName());
						tariff.setUnitprice(v.getUnitprice());
						return trepo.save(tariff);
		}).orElseThrow(()-> new TariffNotFoundException(tariffid));
		
			
		}
	
	@GetMapping("/Tariffid")
	public List<Integer> doGetId(){
		System.out.println(trepo.getIdList());
		return trepo.getIdList();
		
	}
	@GetMapping("/TariffName")
	public List<String> doGetName(){
		System.out.println(trepo.getIdName());
		return trepo.getIdName();
		
	}
	
	@DeleteMapping("/Tariff/{tariffid}")
	public String doDelete(@PathVariable int tariffid) {
		
	 trepo.deleteById(tariffid);
	 
	 return "Tariff Deleted Successfully";
	}
	
}
