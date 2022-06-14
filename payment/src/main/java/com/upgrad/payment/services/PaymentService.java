package com.upgrad.payment.services;

import com.upgrad.payment.entities.Transaction;

public interface PaymentService {
    public Transaction createTransaction(Transaction trn);

    public Transaction getTransaction(int id);
    public Transaction getTransactionbytrnid(int id);

    

}
