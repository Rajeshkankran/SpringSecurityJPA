package com.tupa.app.data.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tupa.app.data.model.Bank;
import com.tupa.app.data.repository.BankRepository;
@Service
public class BankServiceImpl implements BankService {

	@Resource
	BankRepository bankRepo;
	
	@Override
	public Bank createBank(Bank bank) {
	 return	bankRepo.save(bank);
	}

}
