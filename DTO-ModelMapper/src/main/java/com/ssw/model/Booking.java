package com.ssw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	private int pnr;
	private String source;
	private String destination;
	private long trainNo;
	private String trainName;
}
