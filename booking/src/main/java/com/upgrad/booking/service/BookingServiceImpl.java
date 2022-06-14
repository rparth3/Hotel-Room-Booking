package com.upgrad.booking.service;

import com.upgrad.booking.dao.BookingDao;
import com.upgrad.booking.entities.Booking;
import java.time.temporal.ChronoUnit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  private BookingDao bookingDao ;

  @Override
  public Booking createUser(Booking booking) {
	  booking.setbookedOn(null);
    return bookingDao.save(booking);
  }

  
  @Override
  public Booking updateBooking(Booking booking) {
	  booking.setbookedOn(null);
	  try {
	  //bookingDao.deleteById(booking.getBookingId());
     bookingDao.save(booking);
	  }
	  catch(Exception ex){
		  
	  }
     return null;
  }
  
  
  @Override
  public Booking getBookingBasedOnId(int id) {

    Optional<Booking> user = bookingDao.findById(id);
    if(user.isPresent())
      return user.get();
    return null;
  }

  /*@Override
  public Booking updateUser(Booking user) {
	  Booking storedUser = getUserBasedOnId(user.getUserId());

    // Copy the content of user into storedUser object

    storedUser.setDateOfBirth(user.getDateOfBirth());
    storedUser.setFirstName(user.getFirstName());
    storedUser.setDateOfBirth(user.getDateOfBirth());
    storedUser.setLastName(user.getLastName());
    storedUser.setPassword(user.getPassword());
    storedUser.setPhoneNumbers(user.getPhoneNumbers());
    storedUser.setUserId(user.getUserId());
    storedUser.setUserName(user.getUserName());

    return userDao.save(storedUser);
  }*/
  
  @Override
  public Booking bookingcalculation(Booking bk) {
	  LocalDateTime fromdate = bk.getFromDate();
	  LocalDateTime todate = bk.getToDate();
	  int   noofdays = (int) ChronoUnit.DAYS.between(fromdate, todate);
	  int  price =  (1000 * noofdays * bk.getNumOfRooms());
	  bk.setRoomPrice(price);
	  bk.setRoomNumbers(getRandomNumbers(bk.getNumOfRooms()));
	  System.out.println(" diff is diff "+noofdays);
	  return bk;
  }

  @Override
  public  String getRandomNumbers(int count){                
      Random rand = new Random();                
      int upperBound = 100;                
      String Roomnos = "";

     for (int i=0; i<count; i++){   
    	 if(i==0)
    	 Roomnos = Roomnos +""+ String.valueOf(rand.nextInt(upperBound)); 
    	 else
        	 Roomnos = Roomnos +", "+ String.valueOf(rand.nextInt(upperBound)); 

      }                

       return Roomnos;                
}
  

  @Override
  public List<Booking> getAllBookings() {
    return bookingDao.findAll();
  }

}
