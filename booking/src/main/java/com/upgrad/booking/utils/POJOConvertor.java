package com.upgrad.booking.utils;

import com.upgrad.booking.dto.BookingDTO;
import com.upgrad.booking.entities.Booking;


public class POJOConvertor {

  public static BookingDTO covertUserEntityToDTO(Booking booking) {
	  BookingDTO bookingDTO = new BookingDTO();
	  
	  bookingDTO.setAadharNumber(booking.getAadharNumber());
	  bookingDTO.setBookedOn(booking.getbookedon());
	  bookingDTO.setBookingId(booking.getBookingId());
	  bookingDTO.setFromDate(booking.getFromDate());
	  bookingDTO.setNumOfRooms(booking.getNumOfRooms());
	  bookingDTO.setRoomNumbers(booking.getRoomNumbers());
	  bookingDTO.setRoomPrice(booking.getRoomPrice());
	  bookingDTO.setToDate(booking.getToDate());
	  bookingDTO.setTransactionId(booking.getTransactionId());

    return bookingDTO;
  }

  public static Booking covertBookingDTOToEntity(BookingDTO bookingdto) {
	  Booking objbooking = new Booking();
	  objbooking.setAadharNumber(bookingdto.getAadharNumber());
	  objbooking.setFromDate(bookingdto.getFromDate());
	  objbooking.setToDate(bookingdto.getToDate());
	  objbooking.setNumOfRooms(bookingdto.getNumOfRooms());
	  objbooking.setbookedOn(bookingdto.getBookedOn());
	  objbooking.setBookingId(bookingdto.getBookingId());
	  objbooking.setRoomNumbers(bookingdto.getRoomNumbers());
	  objbooking.setRoomPrice(bookingdto.getRoomPrice());
	  objbooking.setTransactionId(bookingdto.getTransactionId());


   /* user.setDateOfBirth(userDTO.getDateOfBirth());
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setPassword(userDTO.getPassword());
    user.setPhoneNumbers(userDTO.getPhoneNumbers());
    user.setUserId(userDTO.getUserId());
    user.setUserName(userDTO.getUsername());
*/
    return objbooking;
  }
}
