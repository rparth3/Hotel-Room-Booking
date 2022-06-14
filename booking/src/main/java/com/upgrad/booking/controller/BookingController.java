package com.upgrad.booking.controller;

import com.upgrad.booking.dto.BookingDTO;
import com.upgrad.booking.dto.TransactionDTO;
import com.upgrad.booking.entities.Booking;
import com.upgrad.booking.service.BookingService;
import com.upgrad.booking.utils.ErrClass;
import com.upgrad.booking.utils.POJOConvertor;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "hotel")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO) {
		System.out.println(" inside post booking method in controller ");
		Booking booking = POJOConvertor.covertBookingDTOToEntity(bookingDTO);
		Booking bookingcal = bookingService.bookingcalculation(booking);
		Booking SavedBooking = bookingService.createUser(bookingcal);

		BookingDTO savedBookingDTO = POJOConvertor.covertUserEntityToDTO(booking);

		return new ResponseEntity(savedBookingDTO, HttpStatus.CREATED);
	}

	@PostMapping(value = "/updatebooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO) {
		System.out.println(" inside post upatebooking method in controller ");
		Booking booking = POJOConvertor.covertBookingDTOToEntity(bookingDTO);
		Booking bookingcal = bookingService.bookingcalculation(booking);
		Booking SavedBooking = bookingService.updateBooking(bookingcal);

		BookingDTO savedBookingDTO = POJOConvertor.covertUserEntityToDTO(booking);

		return savedBookingDTO ;
	}
	
	@GetMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity GetAllUsers() {
		List<Booking> bookingList = bookingService.getAllBookings();

		List<BookingDTO> bookingDToList = new ArrayList<>();

		bookingList.forEach(u -> bookingDToList.add(POJOConvertor.covertUserEntityToDTO(u)));

		return new ResponseEntity(bookingDToList, HttpStatus.OK);

	}

	@GetMapping(value = "/booking/{id}")
	public BookingDTO getUser(@PathVariable(name = "id") int id) {
		System.out.println(" in side booking control get booking ");
		Booking Booking = (bookingService.getBookingBasedOnId(id));

		if (Booking != null) {
			BookingDTO BookingDTO = POJOConvertor.covertUserEntityToDTO(Booking);
			return BookingDTO;//new ResponseEntity(BookingDTO, HttpStatus.OK);
		} else {
			return null;
		}
	}

	// new

	@PostMapping(value = "booking/{id}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateMovieDetails(@PathVariable(name = "id") int id, @RequestBody TransactionDTO transactionDTO) {
		System.out.println(" hello from controller" + transactionDTO);
		

		 
		 HttpHeaders headers = new HttpHeaders();

		    RestTemplate restTemplate = new RestTemplate();
		    TransactionDTO r ;
		    
		    
		 try {
		    BookingDTO res = 
		    		restTemplate.postForEntity
		    		("http://localhost:8083/payment/payment/",transactionDTO, BookingDTO.class)
		    		.getBody();
		    return new ResponseEntity(res, HttpStatus.OK);
		    
		 }
		 catch(Exception ex) {
			 
			 return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		 }
		
	}

	@PostMapping(value = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity Paymentprocess(@RequestBody TransactionDTO transactionDto) {
		System.out.println(" inside post payment method in controller ");
	//	Transaction objpayment = POJOConvertor.covertBookingDTOToEntity(transactionDto);
		
		//transaction
		
		
		 
		    return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		/*ErrClass err = Util.checkValidation(objpayment);
		Boolean B = false;
		if (err == null) {
			B = true;
		}
		if (B) {
			Transaction SavedTransaction = paymentService.createTransaction(objpayment);

			TransactionDTO savedTransactionDTO = Util.covertUserEntityToDTO(SavedTransaction);
			return new ResponseEntity(savedTransactionDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
		}*/

	}

}