package com.upgrad.payment.util;

import com.upgrad.payment.dto.*;
import com.upgrad.payment.entities.*;

public class Util {

	public static TransactionDTO covertUserEntityToDTO(Transaction tran) {
		TransactionDTO trnDTO = new TransactionDTO();

		trnDTO.setBookingId(tran.getBookingId());
		trnDTO.setCardNumber(tran.getCardNumber());
		trnDTO.setPaymentMode(tran.getPaymentMode());
		trnDTO.setUpiId(tran.getUpiId());
		trnDTO.setTransactionId(tran.getTransactionId());


		return trnDTO;
	}

	public static Transaction covertBookingDTOToEntity(TransactionDTO tDTO) {
		Transaction objtrn = new Transaction();
		objtrn.setBookingId(tDTO.getBookingId());	
		objtrn.setCardNumber(tDTO.getCardNumber());
		objtrn.setPaymentMode(tDTO.getPaymentMode());
		objtrn.setTransactionId(tDTO.getTransactionId());
		objtrn.setUpiId(tDTO.getUpiId());

		


		/*
		 * user.setDateOfBirth(userDTO.getDateOfBirth());
		 * user.setFirstName(userDTO.getFirstName());
		 * user.setLastName(userDTO.getLastName());
		 * user.setPassword(userDTO.getPassword());
		 * user.setPhoneNumbers(userDTO.getPhoneNumbers());
		 * user.setUserId(userDTO.getUserId()); user.setUserName(userDTO.getUsername());
		 */
		return objtrn;
	}
	
	public static ErrClass checkValidation(Transaction t ) {
		ErrClass err = new ErrClass();
		if(!"UPI".equals(t.getPaymentMode()) && !"CARD".equals(t.getPaymentMode()))
		{
			err.setMessage("Invalid mode of payment");
			err.setStatusCode(400);
			return err;
		}
		
	return null;
	}
}
