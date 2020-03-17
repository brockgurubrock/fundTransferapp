package com.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.FundTransferReqdto;
import com.bank.dto.TransactionIddto;
import com.bank.entity.Transaction;
import com.bank.service.FundService;
import com.bank.service.TransactionService;

@RestController
public class FundController {
	@Autowired
	private FundService  fundService;
	@Autowired
	private TransactionService transactionService;
	
	public ResponseEntity<Void>fundTransfer(@RequestBody FundTransferReqdto fundTransferReqdto)
	{
		fundService.fundTransfer(fundTransferReqdto);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	public ResponseEntity<Transaction>retriveTheTransactionByAccountId(@RequestBody TransactionIddto reqdto)
	{
		transactionService.getAllTransaction(reqdto.getAccountId());
		
		return new ResponseEntity<Transaction>(HttpStatus.OK);
		
	}
	

}
