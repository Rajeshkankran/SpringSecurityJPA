package com.tupa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tupa.app.repository.BankRepository;


@RestController("pollcontroller")
@RequestMapping({"/v1/","/oauth2/v1/"})
public class PollController {
	
	@Autowired
	BankRepository bankRepository;
	
	
	@RequestMapping(value="/poll",method=RequestMethod.GET)
	public String index(){
		
		return "Welcome To Tupa";
	}
	
	
}
