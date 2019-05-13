package com.example.Facebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Operations;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		String clientId= "366207870382295";
		String scret= "a58161e4d58346f311665c2f6e98d2bd";

		FacebookConnectionFactory fcf =new FacebookConnectionFactory(clientId,scret);
		OAuth2Operations auth= fcf.getOAuthOperations();
		String token =auth.authenticateClient().getAccessToken();
		Facebook facebook =new FacebookTemplate(token);
		String name=facebook.restOperations().getForObject("https://graph.facebook.com/{366207870382295}",String.class,"366207870382295");
		System.out.println(name);


	}

}
