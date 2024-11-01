package com.ssw.dto;

import lombok.Data;

@Data
public class BookingDTO {

	private int pid;
	private int pnr;
	private String source;
	private String destination;
	private long trainNo;
	private String trainName;
}
