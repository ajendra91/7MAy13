package com.example.Facebook;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AppController {

    public String clientId= "366207870382295";
    public String secret= "a58161e4d58346f311665c2f6e98d2bd";
    public FacebookConnectionFactory fcf;
    public OAuth2Operations auth;
    public OAuth2Parameters parameters;
    public String url="http://localhost:9090/auth/facebook";

    public AccessGrant ag;
    public String token;
    public Facebook facebook;
    public String[] fields;
    public User user;


    @RequestMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        fcf= new FacebookConnectionFactory(clientId,secret);
        auth= fcf.getOAuthOperations();
        parameters= new OAuth2Parameters();
        parameters.setRedirectUri(url);
        parameters.setScope("public email");
        response.sendRedirect(auth.buildAuthenticateUrl(parameters));
    }

    @RequestMapping("/auth/facebook")
    public String login2(@RequestParam String code){
        ag = fcf.getOAuthOperations().exchangeForAccess(url,code,null);
        token=ag.getAccessToken();
        facebook=new FacebookTemplate(token);
        fields=new String[]{"name","email"};
        user =facebook.fetchObject("me",User.class);
        return user.getName()+""+user.getEmail();

    }
}
