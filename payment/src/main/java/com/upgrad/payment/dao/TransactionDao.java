package com.upgrad.payment.dao;

import com.upgrad.payment.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction,Integer> {

	Object findBybookingId(int id);

}
