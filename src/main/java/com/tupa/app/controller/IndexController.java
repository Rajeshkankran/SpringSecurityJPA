package com.tupa.app.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tupa.app.data.model.Bank;
import com.tupa.app.data.service.BankService;


@RestController
public class IndexController {
	
    @Autowired
	BankService bankService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "Welcome To SpringSecurityJPA";
	}
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		Bank temp = new Bank();
		temp.setBank_mmid_part("12343");
		temp.setBank_name("temp");
		temp.setStatus((byte)1);
		temp.setCreated_on(Calendar.getInstance().getTime());
		temp.setLast_updated_on(Calendar.getInstance().getTime());
		
		bankService.createBank(temp);
		
		return "Welcome To SpringSecurityJPA";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exception) {
		return new ModelAndView("error");
	}
	
	
}
