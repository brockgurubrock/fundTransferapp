package com.bank.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FundTransfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fundtransferId;
	private Long toAccount;
	private double amount;
	private LocalDateTime funtransferDate;
	private Long fromAccount;

	public FundTransfer(Long toAccount, double amount,Long fromAccount) {

		this.toAccount = toAccount;
		this.amount = amount;
		this.funtransferDate = LocalDateTime.now();
		this.fromAccount = fromAccount;
	}

	public Long getFundtransferId() {
		return fundtransferId;
	}

	public void setFundtransferId(Long fundtransferId) {
		this.fundtransferId = fundtransferId;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getFuntransferDate() {
		return funtransferDate;
	}

	public void setFuntransferDate(LocalDateTime funtransferDate) {
		this.funtransferDate = funtransferDate;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public FundTransfer() {

	}

}
