package com.ssw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parent {
	@Id
	private long parentmobileno;
	private String parentname;
	private String adddress;
	private String mailid;

	@Column(unique = true)
	private String username;

	@Column(unique = true)
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Tutor> requestedTutors;

	@ManyToMany
	@JsonIgnore
	private List<Tutor> bookedTutors;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(long parentmobileno, String parentname, String adddress, String mailid, String username,
			String password, List<Tutor> requestedTutors, List<Tutor> bookedTutors) {
		super();
		this.parentmobileno = parentmobileno;
		this.parentname = parentname;
		this.adddress = adddress;
		this.mailid = mailid;
		this.username = username;
		this.password = password;
		this.requestedTutors = requestedTutors;
		this.bookedTutors = bookedTutors;
	}

	public long getParentmobileno() {
		return parentmobileno;
	}

	public void setParentmobileno(long parentmobileno) {
		this.parentmobileno = parentmobileno;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getAdddress() {
		return adddress;
	}

	public void setAdddress(String adddress) {
		this.adddress = adddress;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tutor> getRequestedTutors() {
		return requestedTutors;
	}

	public void setRequestedTutors(List<Tutor> requestedTutors) {
		this.requestedTutors = requestedTutors;
	}

	public List<Tutor> getBookedTutors() {
		return bookedTutors;
	}

	public void setBookedTutors(List<Tutor> bookedTutors) {
		this.bookedTutors = bookedTutors;
	}

}
