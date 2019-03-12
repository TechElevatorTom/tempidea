package com.techelevator;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Song;
import com.techelevator.model.dao.FileSongsDAO;
import com.techelevator.model.dao.SongsDAO;

@Controller 
public class SongController {

	@Autowired
	private SongsDAO dao;
	
	private SongsDAO fileDao = new FileSongsDAO();
	
	@RequestMapping("/")
	public String listSongs(Model modelMap) {
		
		List<Song> songs = dao.getAllSongs();
		List<Song> requests = dao.getAllRequests();

		modelMap.addAttribute("songs", songs);
		modelMap.addAttribute("requests", requests);
		
		return "songList";
	}
	
	@RequestMapping(path="/request", method=RequestMethod.GET)
	public String requestForm() {
		return "songRequest";
	}

	@RequestMapping(path="/request", method=RequestMethod.POST)
	public String submitRequest(Song requestedSong, RedirectAttributes flashScope) {		

		dao.saveRequest(requestedSong);
		flashScope.addFlashAttribute("thankYou", true);
		
		return "redirect:/";
	}
}
