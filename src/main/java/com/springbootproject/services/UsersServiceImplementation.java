package com.springbootproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootproject.entity.Users;
import com.springbootproject.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) 
	{
		repo.save(user);
		return "user added Successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String passWord) {
		Users user=repo.findByEmail(email);
		String db_pwd=user.getPassWord();
		if(passWord.equals(db_pwd))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) 
	{
		Users user=repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) 
	{
		return repo.findByEmail(email);
		
	}

	@Override
	public void updateUser(Users user) 
	{
		repo.save(user);
		
	}

}
