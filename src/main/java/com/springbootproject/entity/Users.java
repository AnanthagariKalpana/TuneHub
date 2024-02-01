package com.springbootproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String userName;
	String email;
	String passWord;
	String gender;
	String role;
	String address;
	boolean isPremium;


	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", email=" + email + ", passWord=" + passWord
				+ ", gender=" + gender + ", role=" + role + ", address=" + address + ", isPremium=" + isPremium + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String userName, String email, String passWord, String gender, String role, String address,
			boolean isPremium) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.isPremium = isPremium;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}


}
