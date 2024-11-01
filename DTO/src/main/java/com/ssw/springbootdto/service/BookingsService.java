package com.ssw.springbootdto.service;

import com.ssw.springbootdto.dto.BookingsDto;

public interface BookingsService {
    BookingsDto createBookings(BookingsDto bookingsDto);

    BookingsDto getBookings(int id);
}
