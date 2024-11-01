package com.ssw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tutor {
	@Id
	private int tutorid;
	private String tutorname;
	private double yearsofexperience;
	private long mobileno;
	private String mailid;
	private String demoAvailable;
	private String bookingAvailable;
	private double rating;

	@Column(unique = true)
	private String username;

	@Column(unique = true)
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Parent> requestedByParent;

	@ManyToMany
	@JsonIgnore
	private List<Parent> bookingParents;

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(int tutorid, String tutorname, double yearsofexperience, long mobileno, String mailid, String demoAvailable,
			String bookingAvailable, double rating, String username, String password, List<Parent> requestedByParent,
			List<Parent> bookingParents) {
		super();
		this.tutorid = tutorid;
		this.tutorname = tutorname;
		this.yearsofexperience = yearsofexperience;
		this.mobileno = mobileno;
		this.mailid = mailid;
		this.demoAvailable = demoAvailable;
		this.bookingAvailable = bookingAvailable;
		this.rating = rating;
		this.username = username;
		this.password = password;
		this.requestedByParent = requestedByParent;
		this.bookingParents = bookingParents;
	}

	public int getTutorid() {
		return tutorid;
	}

	public void setTutorid(int tutorid) {
		this.tutorid = tutorid;
	}

	public String getTutorname() {
		return tutorname;
	}

	public void setTutorname(String tutorname) {
		this.tutorname = tutorname;
	}

	public double getExperience() {
		return yearsofexperience;
	}

	public void setExperience(double experience) {
		this.yearsofexperience = experience;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getDemoAvailable() {
		return demoAvailable;
	}

	public void setDemoAvailable(String demoAvailable) {
		this.demoAvailable = demoAvailable;
	}

	public String getBookingAvailable() {
		return bookingAvailable;
	}

	public void setBookingAvailable(String bookingAvailable) {
		this.bookingAvailable = bookingAvailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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

	public List<Parent> getRequestedByParent() {
		return requestedByParent;
	}

	public void setRequestedByParent(List<Parent> requestedByParent) {
		this.requestedByParent = requestedByParent;
	}

	public List<Parent> getBookingParents() {
		return bookingParents;
	}

	public void setBookingParents(List<Parent> bookingParents) {
		this.bookingParents = bookingParents;
	}

}
