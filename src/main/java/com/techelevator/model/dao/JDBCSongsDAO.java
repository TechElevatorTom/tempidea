package com.techelevator.model.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Song;

@Component
public class JDBCSongsDAO implements SongsDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSongsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Song> getAllSongs() {
		List<Song> songs = new ArrayList<Song>();
		
		String sql = "SELECT title, artist, album FROM songs";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Song newSong = mapRowToSong(results);
			songs.add(newSong);
		}
		
		return songs;
	}
	
	@Override
	public void saveSong(Song newSong) {
		String sql = "INSERT INTO songs (title, artist, album) VALUES (?, ?, ?) RETURNING song_id";
		SqlRowSet id_holder = jdbcTemplate.queryForRowSet(sql, newSong.getTitle(), newSong.getArtist(), newSong.getAlbum());

		id_holder.next();
		Long id = id_holder.getLong(1);
		newSong.setId(id);		
	}

	@Override
	public List<Song> getAllRequests() {
		List<Song> songs = new ArrayList<Song>();
		
		String sql = "SELECT DISTINCT title, artist, album FROM requests";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Song newRequest = mapRowToSong(results);
			songs.add(newRequest);
		}
		
		return songs;
	}

	@Override
	public void saveRequest(Song newRequest) {
		String sql = "INSERT INTO requests (title, artist, album) VALUES (?, ?, ?) RETURNING request_id";
		SqlRowSet id_holder = jdbcTemplate.queryForRowSet(sql, newRequest.getTitle(), newRequest.getArtist(), newRequest.getAlbum());

		id_holder.next();
		Long id = id_holder.getLong(1);
		newRequest.setId(id);		
	}

	private Song mapRowToSong(SqlRowSet result) {
		Song newSong = new Song();
		newSong.setTitle(result.getString("title"));
		newSong.setArtist(result.getString("artist"));
		newSong.setAlbum(result.getString("album"));
		
		return newSong;
	}

}
