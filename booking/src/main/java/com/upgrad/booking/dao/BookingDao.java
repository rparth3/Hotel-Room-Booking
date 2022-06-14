package com.upgrad.booking.dao;

import com.upgrad.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingDao extends JpaRepository<Booking, Integer> {

}
