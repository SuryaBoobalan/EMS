package com.ebs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class TariffData {

	@Id
	@GeneratedValue
	private int tariffid;
	
	private String tariffName;
	
	private double unitprice;

	public int getTariffid() {
		return tariffid;
	}

	public void setTariffid(int tariffid) {
		this.tariffid = tariffid;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	
	
}
