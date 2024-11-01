package com.ssw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Passenger {

	@Id
	private int pid;
	private String pname;
	private long pmob;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking>bookings;
}
