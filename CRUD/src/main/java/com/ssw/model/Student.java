package com.ssw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private long mobno;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany
	private List<Book> blist;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Book> getBlist() {
		return blist;
	}

	public void setBlist(List<Book> blist) {
		this.blist = blist;
	}

	public Student(int rollno, String name, long mobno, Address address, List<Book> blist) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.mobno = mobno;
		this.address = address;
		this.blist = blist;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", mobno=" + mobno + ", address=" + address + ", blist="
				+ blist + "]";
	}


}
