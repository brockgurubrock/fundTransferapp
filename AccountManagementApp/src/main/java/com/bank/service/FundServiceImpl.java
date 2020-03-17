package com.bank.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.FundTransferReqdto;
import com.bank.entity.Account;
import com.bank.entity.FundTransfer;
import com.bank.entity.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.FundTransferRepository;
import com.bank.repository.TransactionRepository;

@Service
@Transactional
public class FundServiceImpl implements FundService {
	@Autowired
	private FundTransferRepository fundTransferRepository;
	@Autowired
	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;

	@Override
	public void fundTransfer(FundTransferReqdto transferReqdto) {
		Account accountWithdraw = accountRepository.findByAccountNumber(transferReqdto.getFromAccountNumber());
		if ((accountWithdraw.getAvailableBalance()) - transferReqdto.getAmount() >= 1000) {
			accountWithdraw.setAvailableBalance(accountWithdraw.getAvailableBalance() - transferReqdto.getAmount());
			Transaction debit = new Transaction(transferReqdto.getAmount(), "debit", LocalDateTime.now(),
					"debited Successfully", "debited");
			transactionRepository.save(debit);
			accountRepository.save(accountWithdraw);

			Account accountdeposit = accountRepository.findByAccountNumber(transferReqdto.getToAccountNumber());
			accountdeposit.setAvailableBalance(accountdeposit.getAvailableBalance() + transferReqdto.getAmount());
			Transaction success = new Transaction(transferReqdto.getAmount(), "debit", LocalDateTime.now(),
					"debited Successfully", "success");
			transactionRepository.save(success);
			FundTransfer fundTransfer = new FundTransfer(transferReqdto.getToAccountNumber(),
					transferReqdto.getAmount(), transferReqdto.getFromAccountNumber());
			fundTransferRepository.save(fundTransfer);
			accountRepository.save(accountdeposit);

		} else {
			Transaction failure = new Transaction(transferReqdto.getAmount(), "debit", LocalDateTime.now(),
					" ", "failure");
			transactionRepository.save(failure);

		}

	}

}
