package com.techelevator.model.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.model.Song;

public class FileSongsDAO implements SongsDAO {

	private static final String FILE_NAME = "/WEB-INF/song_requests.csv";
	private static final File FILE = new File(FILE_NAME);
		
	@Override
	public List<Song> getAllSongs() {
		List<Song> songs = new ArrayList<Song>();
		Scanner fileInput = new Scanner(FILE_NAME);
		while(fileInput.hasNextLine()) {
			String currentLine = fileInput.nextLine();
			String[] parts = currentLine.split(",");
			
			Song newSong = new Song();
			newSong.setTitle(parts[0]);
			newSong.setArtist(parts[1]);
			newSong.setAlbum(parts[2]);
			
			songs.add(newSong);
		}
		
		return songs;
	}

	@Override
	public void saveSong(Song newSong) {
		PrintWriter appendWriter = null;
		try {
			appendWriter = new PrintWriter(FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String output = newSong.getTitle() + "," + newSong.getArtist() + "," + newSong.getAlbum();
		appendWriter.println(output);
		appendWriter.close();
	}

	@Override
	public List<Song> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRequest(Song newRequest) {
		// TODO Auto-generated method stub
		
	}
	
}
