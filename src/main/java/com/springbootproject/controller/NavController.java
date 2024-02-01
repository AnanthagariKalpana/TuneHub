package com.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController 
{
	@GetMapping("/log")
	public String login()
	{
		return "login";
	}
	@GetMapping("/reg")
	public String register()
	{
		return "register";
	}
	@GetMapping("/newsong")
	public String newsong()
	{
		return "newsong";
	}
	
	
}
