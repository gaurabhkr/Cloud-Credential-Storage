package com.tel.CloudCreden.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tel.CloudCreden.Models.Userlogin;
import com.tel.CloudCreden.Models.userconfi;
import com.tel.CloudCreden.Repo.UserDao;

@Component
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	public UserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Userlogin user=userdao.findByUsername(username);
		
		if(user==null) {System.out.println("User Not Found"); throw new UsernameNotFoundException("User Not Found");}
		
		System.out.println(user.toString());
		
		return new userconfi(user);
	}

}
