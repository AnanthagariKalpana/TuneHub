package com.springbootproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootproject.entity.Song;
import com.springbootproject.entity.Users;
import com.springbootproject.services.SongService;
import com.springbootproject.services.UsersService;

import jakarta.servlet.http.HttpSession;



@Controller
public class UsersController 
{
	@Autowired
	UsersService service;
	@Autowired
	SongService songService;
	
	@PostMapping("/reg")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userStatus=service.emailExists(user.getEmail());
		if(userStatus == false)
		{
		service.addUser(user);
		System.out.println("User is Added");
		}
		else
		{
			System.out.println("User is Already Exsists");
		}
		return "home";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam String email,@RequestParam String passWord,HttpSession session,Model model)
	{
		if(service.validateUser(email,passWord)== true)
		{
			String role=service.getRole(email);
			
			session.setAttribute("email", email);
			 
			if(role.equals("Admin")) 
			{	
				return "adminhome";
			}
			else
			{
				Users user=service.getUser(email);
				boolean userStatus = user.isPremium();
				List<Song> songsList=songService.fetchAllSongs();
				model.addAttribute("songs",songsList);
				model.addAttribute("isPremium",userStatus);
				return "customerhome";
			}
		}
		else
		{
			return"login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
		//logout from the application
		session.invalidate();
		return "login";
	}
	
	
}
