package com.upgrad.booking.service;

import com.upgrad.booking.entities.Booking;

import java.util.ArrayList;
import java.util.List;


public interface BookingService {

  public Booking createUser(Booking user);
  public Booking updateBooking(Booking user);

  

  public Booking getBookingBasedOnId(int id);

  public Booking bookingcalculation(Booking booking);
  public String getRandomNumbers(int count); 


  public List<Booking>  getAllBookings();
}
