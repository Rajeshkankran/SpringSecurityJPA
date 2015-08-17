package com.tupa.app.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.client.RestTemplate;

public class OAuthClient {

	private static final String QUICK_POLL_URI_V1 = "http://localhost:8080/SpringSecurityJPA/v1/poll";
	private static final String OAUTH_TOKEN_URL = "http://localhost:8080/SpringSecurityJPA/oauth/token";
	
	private RestTemplate restTemplate(){
		
		ResourceOwnerPasswordResourceDetails ownerDetails = new ResourceOwnerPasswordResourceDetails();
		
		ownerDetails.setAccessTokenUri(OAUTH_TOKEN_URL);
		ownerDetails.setGrantType("password");
		
		ownerDetails.setUsername("admin");
		ownerDetails.setPassword("admin");
		ownerDetails.setClientId("tupa");
		ownerDetails.setClientSecret("mysecret");
		
		
		List<String> scopes = new ArrayList<String>();
		scopes.add("read");
		scopes.add("write");
		
		ownerDetails.setScope(scopes);
		
		
		return new OAuth2RestTemplate(ownerDetails);
		
	}
	
	public static void main(String[] args) {
		OAuthClient client = new OAuthClient();
		
		String test =client.restTemplate().getForObject(QUICK_POLL_URI_V1,String.class);
		System.out.println(test);
	}
}
