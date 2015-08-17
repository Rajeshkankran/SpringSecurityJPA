package com.tupa.app.config.context;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

public class JwtTokenService  implements AuthorizationServerTokenServices {

	@Override
	public OAuth2AccessToken createAccessToken(
			OAuth2Authentication authentication) throws AuthenticationException {
		
		return null;
	}	

	@Override
	public OAuth2AccessToken refreshAccessToken(String refreshToken,
			TokenRequest tokenRequest) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		return null;
	}

}
