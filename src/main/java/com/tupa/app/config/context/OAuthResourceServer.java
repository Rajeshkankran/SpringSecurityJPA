package com.tupa.app.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuthResourceServer extends ResourceServerConfigurerAdapter {

	protected String RESOURCE_ID = "SpringSecurityJPA";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resource)
			throws Exception {

		resource.resourceId(RESOURCE_ID);

	}
    
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.requestMatchers().antMatchers("/v1/poll/**").and()
				.authorizeRequests().antMatchers("/v1/poll/**").authenticated();
		// .access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))");

	}

}
