package com.springbootproject.services;

import com.springbootproject.entity.Users;

public interface UsersService 
{
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String passWord);
	public String getRole(String email);
	
	public Users getUser(String email);
	public void updateUser(Users user);
}
