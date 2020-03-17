package com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.Account;
import com.bank.entity.FundTransfer;
@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer,Long>{
	

}
