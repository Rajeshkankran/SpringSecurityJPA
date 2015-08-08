package com.tupa.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().withUser("as").password("as")
				.roles("USER");

	}

	@Override
	@Order(Ordered.HIGHEST_PRECEDENCE)
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().authorizeRequests()
		//.antMatchers("/api/v1/**").permitAll()
		
		.antMatchers("/oauth2/v1/**").authenticated().and().httpBasic();
		//.access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))");

}
	
    @Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();

	}

}
