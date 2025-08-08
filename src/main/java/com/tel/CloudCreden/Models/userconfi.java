package com.tel.CloudCreden.Models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class userconfi implements UserDetails{

	private Userlogin user;
	
	public userconfi(Userlogin u){
		super();
		this.user=u;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(getPassword()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
