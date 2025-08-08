package com.tel.CloudCreden.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tel.CloudCreden.Config.JwtService;
import com.tel.CloudCreden.Models.Userlogin;
import com.tel.CloudCreden.Repo.UserDao;

@Component
public class LoginService {
	
	@Autowired
	public UserDao userdao;

	@Autowired
	 AuthenticationManager authenticationmanger;
	
	@Autowired
	private JwtService jwtservice;
	
	public BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	
	public String register(Userlogin u) {
		
		if(userdao.findByUsername(u.getUsername())==null){
			u.setPassword(encoder.encode(u.getPassword()));
		 userdao.save(u);
		 return "Register has been done" + u.toString();
		 }
		System.out.println("User already exist");
		return "User already exist";
	}
	
	
	//use to update password to Bcrypt password
	public String updatepassword(String username,String updatepassword) {
		Userlogin user=userdao.findByUsername(username);
		
		if(user==null) {return "User not found";}
		
		user.setPassword(encoder.encode(updatepassword));
		
		userdao.save(user);
		
		return "Update has been done";
	}
	
	
	public String verify(Userlogin u) {
		Authentication authentication=
				authenticationmanger.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));
		
		if(authentication.isAuthenticated()) {return jwtservice.genratetoken(u);}
		
		return "Not Authorize";
		
	}
	
	
	public String forgotpassword(String username,String newpassword,String securitycode) {
		Userlogin u=userdao.findByUsername(username);
		if(u==null) {return "User has not been found";}
		if(u.getSecuritycode().equals(securitycode)){u.setPassword(encoder.encode(newpassword));userdao.save(u);return "Password has been update";}
		return "Security Code not correct";
	}
	
	
}
