package com.upgrad.booking.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Booking  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int bookingId;

  @Column(nullable = true)
  private LocalDateTime fromDate;

  @Column(nullable = true)
  private LocalDateTime toDate;

  @Column(nullable = true)
  private String aadharNumber;

  @Column(nullable = true)
  private int numOfRooms;

  @Column(nullable = true)
  private String roomNumbers;
  

  @Column(nullable = false)
  private int roomPrice;

  

  @Column()
  private int transactionId;
  

  @Column(nullable = true)
  private LocalDateTime bookedOn;


public int getBookingId() {
	return bookingId;
}


public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}


public LocalDateTime getFromDate() {
	return fromDate;
}


public void setFromDate(LocalDateTime fromDate) {
	this.fromDate = fromDate;
}


public LocalDateTime getToDate() {
	return toDate;
}


public void setToDate(LocalDateTime toDate) {
	this.toDate = toDate;
}


public String getAadharNumber() {
	return aadharNumber;
}


public void setAadharNumber(String aadharNumber) {
	this.aadharNumber = aadharNumber;
}


public int getNumOfRooms() {
	return numOfRooms;
}


public void setNumOfRooms(int numOfRooms) {
	this.numOfRooms = numOfRooms;
}


public String getRoomNumbers() {
	return roomNumbers;
}


public void setRoomNumbers(String roomNumbers) {
	this.roomNumbers = roomNumbers;
}


public int getRoomPrice() {
	return roomPrice;
}


public void setRoomPrice(int roomPrice) {
	this.roomPrice = roomPrice;
}


public int getTransactionId() {
	return transactionId;
}


public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}


public LocalDateTime getbookedon() {
	return this.bookedOn;
}


public void setbookedOn(LocalDateTime bookedOn) {
	LocalDateTime lt    = LocalDateTime.now();
	this.bookedOn = lt;
}

  


}