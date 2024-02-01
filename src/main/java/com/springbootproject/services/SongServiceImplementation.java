package com.springbootproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.Song;
import com.springbootproject.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepository songrepo;
	@Override
	public void addSong(Song song) 
	{
		
		songrepo.save(song);
	}
	
	public  List<Song> fetchAllSongs() {
		return songrepo.findAll();
	}
	@Override
	public boolean songNameExist(String name) {
		Song song=songrepo.findByName(name);
		if(song == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public void updateSong(Song song) {
		songrepo.save(song);
	}

}
