package com.ssw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int adrid;
	private String area;
	private String city;

	public int getAdrid() {
		return adrid;
	}

	public void setAdrid(int adrid) {
		this.adrid = adrid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(int adrid, String area, String city) {
		super();
		this.adrid = adrid;
		this.area = area;
		this.city = city;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
