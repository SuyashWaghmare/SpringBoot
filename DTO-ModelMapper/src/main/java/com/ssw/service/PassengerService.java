package com.ssw.service;

import com.ssw.dto.BookingDTO;
import com.ssw.dto.PassengerDTO;

public interface PassengerService {

	void savePassenger(PassengerDTO passengerdto);

	String bookTicket(BookingDTO bookingdto);

}
