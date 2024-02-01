package com.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootproject.entity.Song;
import com.springbootproject.services.SongService;

@Controller
public class SongController 
{
	@Autowired
	SongService service;
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songStatus=service.songNameExist(song.getName());
		if(songStatus == false)
		{
			service.addSong(song);
			System.out.println("Song is added");
		}
		else
		{
			System.out.println("Song is already Exists");
		}
		
		return "adminhome";
	}
	@GetMapping("/viewsong")
	public String viewSong(Model model)
	{
		List <Song> songlist=service.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "displaysong";
	}
	
	@GetMapping("/playsong")
	public String playSong(Model model)
	{
		boolean preminumUser=false;
		if(preminumUser== true) 
		{
		List <Song> songslist=service.fetchAllSongs();
		model.addAttribute("songs", songslist);
		return "displaysong";
		}
		else
		{
			return "makepayment";
		}
	}
}
