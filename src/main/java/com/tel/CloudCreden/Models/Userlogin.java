package com.tel.CloudCreden.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cred_login")
public class Userlogin {
	//Username must be custom encrypted and password is encrypted with Bcrypt
	
	@Id
	@Column(name="username",unique = true,nullable = false)
	private String username;
	
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="securitycode")
	private String securitycode;
	
	
	
	public Userlogin(){}
	
	public Userlogin(String username, String password, String securitycode) {
		super();
		this.username = username;
		this.password = password;
		this.securitycode = securitycode;
	}

	public Userlogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "Userlogin [username=" + username + ", password=" + password + ", securitycode=" + securitycode + "]";
	}

	
	
	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
