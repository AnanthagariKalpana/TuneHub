package com.springbootproject.services;

import java.util.List;

import com.springbootproject.entity.Song;

public interface SongService 
{
	public void addSong(Song song);
	
	public List<Song> fetchAllSongs();
	
	public boolean songNameExist(String name);
	
	public void updateSong(Song song);
}
