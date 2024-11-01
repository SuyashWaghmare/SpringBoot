package com.ssw.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.dto.BookingDTO;
import com.ssw.dto.PassengerDTO;
import com.ssw.model.Booking;
import com.ssw.model.Passenger;
import com.ssw.repository.PassengerRepository;

@Service
public class PassengerServiceIMPL implements PassengerService{
	private static final Object PassengerDTO = null;
	@Autowired
	private PassengerRepository pripo;
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public void savePassenger(PassengerDTO passengerdto) {
		
//		Passenger passenger=new Passenger();
//		passenger.setPid(passengerdto.getPid());
//		passenger.setPname(passengerdto.getPname());
//		passenger.setPmob(passengerdto.getPmob());
//		
		Passenger passenger = mapper.map(PassengerDTO,Passenger.class);
		pripo.save(passenger);
	}


	@Override
	public String bookTicket(BookingDTO bookingdto) {
		if(pripo.existsById(bookingdto.getPid()))
		{
			Passenger passenger = pripo.findById(bookingdto.getPid()).get();
//			Booking booking =new Booking();
//			
//			booking.setPnr(bookingdto.getPnr());
//			booking.setSource(bookingdto.getSource());
//			booking.setDestination(bookingdto.getDestination());
//			booking.setTrainNo(bookingdto.getPnr());
//			booking.setTrainName(bookingdto.getTrainName());
//			
			Booking booking = mapper.map(bookingdto, Booking.class);
			passenger.getBookings().add(booking);
			pripo.save(passenger);
            return "Booking Sucessfull";
			
			
		}
		return "pid is invalid";
	}
	

}
