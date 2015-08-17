package com.tupa.app.config.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Bean
	public SwaggerSpringMvcPlugin configureSwagger(){
		
		SwaggerSpringMvcPlugin swaggerPlugin = new SwaggerSpringMvcPlugin(springSwaggerConfig);
		
		ApiInfo apiInfo = new ApiInfoBuilder()
		.title("TruPay Api Doc")
		.description("TruPay Restful Services API Doc")
		.termsOfServiceUrl("http://localhost:8080/TruPay")
		.contact("rajesh.k42@incedoinc.com")
		.license("Incedo Inc")
		.build();
		
		swaggerPlugin.apiInfo(apiInfo);
		
		
		return swaggerPlugin;
		
	}
	
	
	
}
