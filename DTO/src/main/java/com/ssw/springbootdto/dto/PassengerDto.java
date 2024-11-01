package com.ssw.springbootdto.dto;

import com.ssw.springbootdto.entity.Bookings;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class PassengerDto {

    private String passengerName;
    private long mobileNumber;

//    @OneToMany
//    private List<Bookings> bookings;
}
