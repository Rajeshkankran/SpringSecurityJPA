package com.tupa.app.config.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationServer extends AuthorizationServerConfigurerAdapter{
	
	   // Logger logger = Logger.getLogger(OAuthAuthorizationServer.class);
		protected String RESOURCE_ID = "SpringSecurityJPA";
		
		@Autowired
		private AuthenticationManager authenticationManager;
		@Override
      	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
      		throws Exception {
			endpoints.authenticationManager(this.authenticationManager).accessTokenConverter(tokenEnhancer());
        }	
		 
		
		
      	@Override
		public void configure(ClientDetailsServiceConfigurer clients)
				throws Exception {
			clients.inMemory().withClient("SpringSecurityJPA")
							  .secret("mysecret")
							  .authorizedGrantTypes("password")
							  .accessTokenValiditySeconds(60 * 60 * 24)
							  .scopes("read", "write")
					          .resourceIds("SpringSecurityJPA");
		//	logger.info("configure-------------------------------------------------------------------------");
		}
      	
      
      	
   /*   	@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			//KeyPair keyPair = new KeyStoreKeyFactory(
			//		new ClassPathResource("keystore.jks"), "foobar".toCharArray())
			//		.getKeyPair("test");
			//converter.setKeyPair(keyPair);
			return converter;
		}*/
      	
     	@Bean
      	public JwtAccessTokenConverter  tokenEnhancer(){
      		JwtAccessTokenConverter enhancer = new JwtAccessTokenConverter();
      		//enhancer.setSigningKey("SpringSecurityJPA");
      		return enhancer;
      	}
      	
     /* 	 
      	 @Bean
      	 public TokenEnhancerChain tokenEnhancerChain(){
             final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
             tokenEnhancerChain.setTokenEnhancers(Lists.newArrayList(new MyTokenEnhancer(), tokenEnhancer()));
             return tokenEnhancerChain;
         }
      	
      	
      	@Autowired
        private ClientDetailsService clientDetailsService;
      @Bean
      @Primary
      	public DefaultTokenServices defaultTokenServices(ClientDetailsService clientDetailsService){
      		
      		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
      		
      		defaultTokenServices.setTokenStore(tokenStore());
            defaultTokenServices.setClientDetailsService(clientDetailsService);
            defaultTokenServices.setTokenEnhancer(tokenEnhancerChain());
            defaultTokenServices.setSupportRefreshToken(true);
            
            return defaultTokenServices;
  	}*/
      	
     /* 	private static class MyTokenEnhancer implements TokenEnhancer {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                final User user = (User) authentication.getPrincipal();
                final Map<String, Object> additionalInfo = new HashMap<>();
                additionalInfo.put("userId", "admin");
                additionalInfo.put("companyId", "assd");
                additionalInfo.put("roles", user.getAuthorities());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                
                            
                return accessToken;
            }
        }
*/
}
