package com.upgrad.payment.entities;

import javax.persistence.*;

@Entity
public class Transaction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId ;

    @Column()
    private String paymentMode ;

    @Column()
    private int bookingId ;
    
    @Column()
    private String upiId ;
    
    @Column()
    private String cardNumber ;
    
    
    

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    
    

}
