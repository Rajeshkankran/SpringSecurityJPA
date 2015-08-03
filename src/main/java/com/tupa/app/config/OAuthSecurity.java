package com.tupa.app.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;



public class OAuthSecurity {

	@EnableResourceServer
	protected static class OAuthResourceServer extends ResourceServerConfigurerAdapter{
		
		protected String RESOURCE_ID ="SpringSecurityJPA";
		
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resource)throws Exception {
		
			resource.resourceId(RESOURCE_ID).stateless(false);
			
		}
		
		
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			
			
			
		}
		
		
		
		
	}
	
	
	protected static class OAuthAthrorizationServer extends AuthorizationServerConfigurerAdapter{
		
	}
	
}
