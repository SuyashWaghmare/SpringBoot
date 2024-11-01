package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssw.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
