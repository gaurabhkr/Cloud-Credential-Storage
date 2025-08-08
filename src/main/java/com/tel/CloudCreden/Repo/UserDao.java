package com.tel.CloudCreden.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tel.CloudCreden.Models.Userlogin;

@Repository
public interface UserDao extends JpaRepository<Userlogin, String>{
	
	public Userlogin findByUsername(String username);

}
