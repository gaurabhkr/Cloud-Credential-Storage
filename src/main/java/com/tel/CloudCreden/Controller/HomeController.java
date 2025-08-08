package com.tel.CloudCreden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import com.tel.CloudCreden.Models.UserD;
import com.tel.CloudCreden.Repo.UserDDao;
import com.tel.CloudCreden.Service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	//Encryption for webusernmae,webpassword and making an tabl for each user 
	
	@Autowired
	private HomeService homservice;

	@GetMapping("")
	@ResponseBody
	public List<UserD> getall(){
		return homservice.getall();
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public String Insert(@RequestBody UserD u) {
		return homservice.Insert(u);
	}
	
	//pr key must be added
//	@GetMapping("/delete")
//	@ResponseBody
//	public String Delete(@RequestParam("link") String link) {
//		return homservice.Delete(link);
//	}
	
	//for use of reqbody we will userD u then in method we send u.getlink()
	@GetMapping("/category")
	@ResponseBody
	public List<UserD> SearchByCategory(@RequestParam("category") String category){
		return homservice.SearchByCategory(category);
	}

	@RequestMapping("/link")
	@ResponseBody
	public List<UserD> SearchByLink(@RequestParam("link") String Link){
		return homservice.SearchByLink(Link);
	}
	
	@PostMapping("/username")
	@ResponseBody
	public String UpdateByWebUsername(@RequestParam("newusername")String newwebusername,
			@RequestParam("previoususername")String previouswebusername,@RequestParam("link")String link) {
		return homservice.UpdateByWebUsername(newwebusername, previouswebusername, link);
	}
	
	@PostMapping("/password")
	@ResponseBody
	public String UpdateByWebPassword(@RequestParam("newwebpassword")String newwebpassword,
			@RequestParam("webusername")String webusername, @RequestParam("link")String link) {
		return  homservice.UpdateByWebPassword(newwebpassword, webusername, link);
	}
	
	@PostMapping("/tes")
	@ResponseBody
	public String UpdateByAbout(@RequestParam("about") String about,@RequestParam("link") String link) {
		return homservice.UpdateByAbout(about, link);
	}}
//	
//	@PostMapping("/tes")
//	@ResponseBody
//	public String UpdateByLink(@RequestParam("newlink")String newlink,@RequestParam("previouslink") String previouslink) {
//		return homservice.UpdateByLink(newlink, previouslink);
//	}
//
//	
//	@PostMapping("/tes")
//	@ResponseBody
//	public String UpdateUsername(@RequestParam("prevwebusername") String prevwebusername,@RequestParam("newwebusername") String newwebusername) {
//		return homservice.UpdateUsername(prevwebusername, newwebusername);
//	}
//}
