package com.tavant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.db.impl.TransactionDAO;
import com.tavant.domain.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	private TransactionDAO transactionDAO;

	@Autowired
	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		transactionDAO.insert(transaction);
	}

}
