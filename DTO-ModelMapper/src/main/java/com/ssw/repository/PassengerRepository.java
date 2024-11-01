package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssw.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
