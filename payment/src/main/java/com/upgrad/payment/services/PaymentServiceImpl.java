package com.upgrad.payment.services;

import com.upgrad.payment.dao.TransactionDao;
import com.upgrad.payment.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{


	  @Autowired
	  private TransactionDao TDAO ;
	
   
    @Override
    public Transaction createTransaction(Transaction trn) {
    	trn.getPaymentMode();
    	return TDAO.save(trn);
    }
    
    @Override
    public Transaction getTransaction(int id) {
      return (Transaction) TDAO.findBybookingId (id);
    }
    

    @Override
    public Transaction getTransactionbytrnid(int id) {
      return TDAO.findById(id).get();
    }
    
}
