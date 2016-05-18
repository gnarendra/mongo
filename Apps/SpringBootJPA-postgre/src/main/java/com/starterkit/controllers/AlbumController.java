package com.starterkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starterkit.domain.Album;
import com.starterkit.services.AlbumService;

import java.util.List;

/**
 * @author Anand.Kittappa@cognizant.com. This AlbumController class for
 *         providing service to incoming client requests
 */
@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	/**
	 * Default welcome file
	 * 
	 * @param model
	 * @return welcome.html
	 * @throws Exception
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	/**
	 * This method maps to GET type of HTTP request with /albums URL. Get the
	 * list of tasks from DB by calling the getAlbumList service. Send the album
	 * list as a response
	 * 
	 * @param model
	 * @return albums
	 */
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public @ResponseBody List<Album> listProducts(Model model) {
		List<Album> albums = (List<Album>) albumService.getAlbumList();
		return albums;
	}

	/**
	 * This method maps to GET type of HTTP request with /deletealbum URL. Get
	 * the inputs from user via requestparam and delete the task from DB by
	 * calling removeAlbum service. Send the album list as a response
	 * 
	 * @param id
	 * @param model
	 * @return albums
	 */
	@RequestMapping(value = "/deletealbum", method = RequestMethod.GET)
	public @ResponseBody List<Album> deleteAlbum(@RequestParam("id") String id, Model model) {
		albumService.removeAlbum(id);
		List<Album> albums = albumService.getAlbumList();
		return albums;
	}

	/**
	 * This method maps to POST type of HTTP request with /addAlbum URL. Get the
	 * inputs from user via requestparam and save the album into DB by calling
	 * saveAlbum service. Send the album list as a response
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @param model
	 * @return albums
	 */
	@RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
	public @ResponseBody List<Album> addAlbum(@RequestParam(value = "title") String title,
			@RequestParam(value = "artist") String artist, @RequestParam(value = "releaseYear") String releaseYear,
			Model model) {

		// Album album = new Album(title, artist, releaseYear);
		albumService.saveAlbum(title, artist, releaseYear);
		List<Album> albums = albumService.getAlbumList();
		return albums;
	}

	/**
	 * This method maps to POST type of HTTP request with /editAlbum URL. Get
	 * the inputs from user via requestparam and update the task into DB by
	 * calling editAlbum service. Send the album list as a response
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @param id
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/editAlbum", method = RequestMethod.POST)
	public @ResponseBody List<Album> editAlbum(@RequestParam(value = "title") String title,
			@RequestParam(value = "artist") String artist, @RequestParam(value = "releaseYear") String releaseYear,
			@RequestParam(value = "id", required = true) String id, Model model) {

		Album album = new Album(title, artist, releaseYear);
		album.setId(id);
		albumService.editAlbum(id, title, artist, releaseYear);
		List<Album> albums = albumService.getAlbumList();
		return albums;
	}
}
