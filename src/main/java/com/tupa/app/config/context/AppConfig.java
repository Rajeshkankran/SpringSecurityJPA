package com.tupa.app.config.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={"com.tupa.app.controller","com.tupa.app.data.service","com.tupa.app.exception.handler"})
public class AppConfig {

	//Logger logger = Logger.getLogger(AppConfig.class);
	
}
