package com.ssw.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Customer {
	@Id
	private long cmob;
	private String cname;
	private String caddress;
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductOrder> orderlist;

	public long getCmob() {
		return cmob;
	}
	
	
	
	

	public void setCmob(long cmob) {
		this.cmob = cmob;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ProductOrder> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<ProductOrder> orderlist) {
		this.orderlist = orderlist;
	}

	public Customer(long cmob, String cname, String caddress, String email, List<ProductOrder> orderlist) {
		super();
		this.cmob = cmob;
		this.cname = cname;
		this.caddress = caddress;
		this.email = email;
		this.orderlist = orderlist;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [cmob=" + cmob + ", cname=" + cname + ", caddress=" + caddress + ", email=" + email
				+ ", orderlist=" + orderlist + "]";
	}

}
