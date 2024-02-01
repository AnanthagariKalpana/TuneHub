package com.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springbootproject.entity.PlayList;
import com.springbootproject.entity.Song;
import com.springbootproject.services.PlaylistService;
import com.springbootproject.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PlayListController 
{
	@Autowired
	SongService songserv;
	@Autowired
	PlaylistService playserv;
	@GetMapping("createplaylist")
	public String createPlaylist(Model model)
	{
		List<Song> songlist=songserv.fetchAllSongs();
		model.addAttribute("songs" ,songlist);
		return "createplaylist";
	}
	
	@PostMapping("addPlaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) 
	{
		playserv.addPlaylist(playlist);
		
		//updating song table
		List<Song> songlist=playlist.getSongs();
		for(Song s: songlist)
		{
			//List<PlayList>pylist=s.getPlayList();
			//s.setPlayList(pylist);
			s.getPlayList().add(playlist);
			//update song Object in DB
			songserv.updateSong(s);
		}
		return "adminhome";
	}
	@GetMapping("viewplaylist")
	public String viewPlaylist(Model model)
	{
		List<PlayList> allplaylists=playserv.fetchAllPlaylists();
		model.addAttribute("allplaylists", allplaylists);
		
		return "displayplaylist";
	}
	
}
