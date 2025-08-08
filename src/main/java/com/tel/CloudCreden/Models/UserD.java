package com.tel.CloudCreden.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="defaulttabll")
public class UserD {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="link",nullable=false)
	private String Link;
	
	@Column(name="about")
	private String About;
	
	@Column(name="username")
	private String WebUsername;
	
	@Column(name="password")
	private String WebPassword;
	
	@Column(name="category",nullable = false)
	private String Category;

	
	
	public UserD(int id, String link, String about, String webUsername, String webPassword, String category) {
		super();
		this.id = id;
		Link = link;
		About = about;
		WebUsername = webUsername;
		WebPassword = webPassword;
		Category = category;
	}

	public UserD(String link, String about, String category) {
		super();
		this.Link = link;
		this.About = about;
		this.Category = category;
	}
	
	public UserD(){}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		this.Link = link;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		this.About = about;
	}


	public String getWebUsername() {
		return WebUsername;
	}

	public void setWebUsername(String webUsername) {
		WebUsername = webUsername;
	}

	public String getWebPassword() {
		return WebPassword;
	}

	public void setWebPassword(String webPassword) {
		WebPassword = webPassword;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	@Override
	public String toString() {
		return "UserD [link=" + Link + ", about=" + About + ", webusername=" + WebUsername + ", webpassword="
				+ WebPassword + ", category=" + Category + "]";
	}
	
}
