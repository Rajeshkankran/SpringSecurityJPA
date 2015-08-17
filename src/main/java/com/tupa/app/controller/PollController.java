package com.tupa.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("pollcontroller")
@RequestMapping({"/v1/"})
public class PollController {
	
//	@Autowired
//	BankRepository bankRepository;
	
	
	@RequestMapping(value="/poll",method=RequestMethod.GET)
	public String index() {
		
		//throw new SampleException("exxxlxlx");
		return "Welcome To Tupa";
	}
	
}
