package com.tel.CloudCreden.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tel.CloudCreden.Models.Userlogin;
import com.tel.CloudCreden.Service.LoginService;



@RequestMapping("")
@RestController
public class LoginController {
	

	@Autowired 
	public LoginService loginservice;
	
	
	
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		System.out.println("Home Contorller is Running");
		return "Homecontroller";
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody Userlogin u) {
	System.out.println("Register of User");
	return loginservice.register(u);
	}

	
	//We are using requestparm but we will use reqattribute in form and put it in post request to not show in link
	@RequestMapping("/updatepassword")
	@ResponseBody
	public String updatepassword(@RequestParam("Username") String username,@RequestParam("password") String password) {
		return loginservice.updatepassword("user1",password);
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody Userlogin u) {
		System.out.println("Login");
		System.out.println(u.toString());
		return loginservice.verify(u);
	}
	
	
	@RequestMapping("/forgotpassword")
	@ResponseBody
	public String forgotpassword(@RequestParam("username") String username,
			@RequestParam("newpassword")String newpassword,@RequestParam("securitycode") String securitycode) {
		return loginservice.forgotpassword(username, newpassword, securitycode);
	}
}
