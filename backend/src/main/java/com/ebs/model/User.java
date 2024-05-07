package com.ebs.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity


public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String userName;
	
	private String division;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Calculated> calc;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public List<Calculated> getCalc() {
		return calc;
	}

	public void setCalc(List<Calculated> calc) {
		this.calc = calc;
	}
	
	
}
