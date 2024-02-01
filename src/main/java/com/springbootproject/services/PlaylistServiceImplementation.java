package com.springbootproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.PlayList;
import com.springbootproject.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepository playrepo;

	@Override
	public void addPlaylist(PlayList playlist) 
	{
		playrepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchAllPlaylists() {
		
		return playrepo.findAll();
		
	}

}
