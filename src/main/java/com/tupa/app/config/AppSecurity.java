package com.tupa.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().withUser("as").password("as").roles("USER");
		
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * // TODO Auto-generated method stub
	 * http.authorizeRequests().antMatchers("/*").hasRole("USER").and().
	 * formLogin().permitAll(); }
	 */
	
	

}
