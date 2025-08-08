package com.tel.CloudCreden.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.tel.CloudCreden.Models.UserD;
import com.tel.CloudCreden.Repo.UserDDao;

@Component
public class HomeService {
//encrypt the webusername and webpassword,each user has a table ,table name is encrypted username
	
	@Autowired
	private UserDDao userdao;
	

	public List<UserD> getall(){
		return userdao.getall();
	}
	
	public List<UserD> SearchByCategory(String category){
		return userdao.findByCategory(category);
	}

	public List<UserD> SearchByLink(String Link){
		return userdao.findByLink(Link);
	}

	public String Insert(UserD u) {
		userdao.insertentry(u);
		return u.toString()+" has been Inserted";
		}

	public String UpdateByWebUsername(String newwebusername,String previouswebusername,String link) {
		userdao.updatebyusername(newwebusername, previouswebusername, link);
		return "Username has been updated";
	}
	

	public String UpdateByWebPassword(String newwebpassword,String webusername,String link) {
		userdao.updatebypassword(newwebpassword, webusername, link);
		return "Password has been updated";
	}
	

	public String UpdateByAbout(String about,String link) {
		userdao.updatebyabout(about, link);
		return "About has been Updated";
	}
	

	public String UpdateByLink(String newlink,String previouslink) {
		userdao.updatebylink(newlink, previouslink);
		return "Link has been updated";
	}

	//pr key must be added
//	public String Delete(String link) {
//		userdao.deleteentry(link);
//		return "Delete has been done";
//	}
	
	public String UpdateUsername(String prevwebusername,String newwebusername) {
//		userdao.changeusername(prevwebusername, newwebusername);
		return "Username has been Changed";
	}
	
}
