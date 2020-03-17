package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.entity.Transaction;
import com.bank.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getAllTransaction(Long accountId) {
		List<Transaction>transactions= transactionRepository.findByAccountAccountId(accountId);
		return transactions;
	}

	

}
