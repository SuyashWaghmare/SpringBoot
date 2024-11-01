package com.ssw.springbootdto.serviceimpl;

import com.ssw.springbootdto.dto.BookingsDto;
import com.ssw.springbootdto.entity.Bookings;
import com.ssw.springbootdto.repository.BookingsRepository;
import com.ssw.springbootdto.service.BookingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsServiceimpl implements BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingsDto createBookings(BookingsDto bookingsDto) {

        Bookings bookings = modelMapper.map(bookingsDto, Bookings.class);

        Bookings savedBookings = bookingsRepository.save(bookings);


        return modelMapper.map(savedBookings, BookingsDto.class);
    }

    @Override
    public BookingsDto getBookings(int id) {

        Bookings bookings = bookingsRepository.findById(id).get();

        BookingsDto bookingsDto = modelMapper.map(bookings, BookingsDto.class);


        return bookingsDto;
    }
}
