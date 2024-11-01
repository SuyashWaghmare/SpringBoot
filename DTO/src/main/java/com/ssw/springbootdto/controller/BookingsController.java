package com.ssw.springbootdto.controller;

import com.ssw.springbootdto.dto.BookingsDto;
import com.ssw.springbootdto.dto.PassengerDto;
import com.ssw.springbootdto.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings-api")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @PostMapping("/createBookings")
    ResponseEntity<BookingsDto> createBookings(@RequestBody BookingsDto bookingsDto) {


        return new ResponseEntity<BookingsDto>(bookingsService.createBookings(bookingsDto), HttpStatus.CREATED);
    }

    @GetMapping("/getBookings/{id}")
    ResponseEntity<BookingsDto> getBookings(@PathVariable int id) {

        return new ResponseEntity<>(bookingsService.getBookings(id),HttpStatus.OK);
    }


}
