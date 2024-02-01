package com.springbootproject.services;

import java.util.List;

import com.springbootproject.entity.PlayList;

public interface PlaylistService 
{
	public void addPlaylist(PlayList playlist);
	public List<PlayList> fetchAllPlaylists();
}
