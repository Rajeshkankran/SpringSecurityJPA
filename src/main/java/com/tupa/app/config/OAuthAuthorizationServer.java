package com.tupa.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationServer extends AuthorizationServerConfigurerAdapter{

		protected String RESOURCE_ID = "SpringSecurityJPA";
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
      	@Override
      	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
      		throws Exception {
      	endpoints.authenticationManager(this.authenticationManager);
      	}	


      	@Override
		public void configure(ClientDetailsServiceConfigurer clients)
				throws Exception {
			// clients.jdbc(dataSource);
			clients.inMemory().withClient("tupa").secret("mysecret")
					.authorizedGrantTypes("password").scopes("read", "write")
					.resourceIds("SpringSecurityJPA");

		}


}
