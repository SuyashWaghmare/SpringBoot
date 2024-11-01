package com.ssw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.dto.BookingDTO;
import com.ssw.dto.PassengerDTO;
import com.ssw.service.PassengerService;

@RestController
@RequestMapping("/irctc-app")
public class IRCTCController {

	@Autowired
	private PassengerService service;
	
	@PostMapping("/save")
	public ResponseEntity<PassengerDTO>savePassenger(@RequestBody PassengerDTO passengerdto)
	{
		service.savePassenger(passengerdto);
		return ResponseEntity.status(HttpStatus.OK).body(passengerdto);
	}
	
	@PostMapping("/bookticket")
	public ResponseEntity<String> bookTicket(@RequestBody BookingDTO bookingdto)
	{
		
		String msg=service.bookTicket(bookingdto);
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	

	

	
	
}
