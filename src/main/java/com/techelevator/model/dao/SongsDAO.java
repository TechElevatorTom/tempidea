package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.Song;

public interface SongsDAO {
	List<Song> getAllSongs();
	void saveSong(Song newSong);
	
	List<Song> getAllRequests();
	void saveRequest(Song newRequest);
	
}
