package com.tupa.app.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tupa.app.data.Bank;
import com.tupa.app.repository.BankRepository;


@RestController
public class IndexController {
	
	@Autowired
	BankRepository bankRepository;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		Bank temp = new Bank();
		temp.setBank_mmid_part("12343");
		temp.setBank_name("temp");
		temp.setStatus("A");
		temp.setCreated_on(Calendar.getInstance().getTime());
		temp.setLast_updated_on(Calendar.getInstance().getTime());
		
		bankRepository.save(temp);
		return "Welcome To SpringSecurityJPA";
	}
	
}
