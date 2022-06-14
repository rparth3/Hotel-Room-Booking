package com.upgrad.payment.controller;

import com.upgrad.payment.dto.BookingDTO;
import com.upgrad.payment.dto.TransactionDTO;
import com.upgrad.payment.entities.Transaction;
import com.upgrad.payment.services.PaymentService;
import com.upgrad.payment.util.ErrClass;
import com.upgrad.payment.util.Util;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	ModelMapper modelMapper;

	

	@PostMapping(value = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity gentrnsaction(@RequestBody TransactionDTO transactionDto) {
		System.out.println(" inside post payment method in controller ");
		Transaction objpayment = Util.covertBookingDTOToEntity(transactionDto);
		
		ErrClass err = Util.checkValidation(objpayment);
		Boolean B = false;
		if (err == null) {
			B = true;
		}
		if (B) {
			Transaction SavedTransaction = paymentService.createTransaction(objpayment);
			
			TransactionDTO savedTransactionDTO = Util.covertUserEntityToDTO(SavedTransaction);
			
		 
		
		 BookingDTO r ;
		try {
		 HttpHeaders headers = new HttpHeaders();

		    RestTemplate restTemplate = new RestTemplate();
		     r = 
		    		restTemplate.getForEntity
		    		("http://localhost:8081/hotel/booking/"+
		    		transactionDto.getBookingId(), BookingDTO.class)
		    		.getBody();
		    
			System.out.println(" r result "+r);
			r.setTransactionId( SavedTransaction.getTransactionId());
  
		    HttpHeaders headersforupdate = new HttpHeaders();

		    RestTemplate restTemplateforupdate = new RestTemplate();
		    BookingDTO res = 
		    		restTemplateforupdate.postForEntity
		    		("http://localhost:8081/hotel/updatebooking/",r, BookingDTO.class)
		    		.getBody();
		   
		System.out.println(" res result "+res);
		r = res;
	}
		catch(Exception ex) {
			r = null;
		}
		
		String message = 	 "Booking confirmed for user with aadhaar number: " +
								 r.getAadharNumber() + "    |    " +
								 "Here are the booking details:    " + r.toString();
		System.out.println(message);
								 
		return new ResponseEntity(r, HttpStatus.CREATED);
	}
		else {
			return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getTransactionid(@RequestBody TransactionDTO transactionDto) {
		System.out.println(" inside post payment method in controller ");
		Transaction objpayment = Util.covertBookingDTOToEntity(transactionDto);
		Transaction SavedTransaction = paymentService.getTransaction(objpayment.getBookingId());
		
	
			return new ResponseEntity(SavedTransaction.getTransactionId(), HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping(value="/transaction/{id}")
	  public ResponseEntity getTransactionbyid(@PathVariable(name="id") int id){
	    Transaction trnOBJ = paymentService.getTransactionbytrnid(id);
		TransactionDTO savedTransactionDTO = Util.covertUserEntityToDTO(trnOBJ);

	    return new ResponseEntity(savedTransactionDTO, HttpStatus.OK);
	  }
		

}
