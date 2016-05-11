package com.starterkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starterkit.domain.Album;
import com.starterkit.services.AlbumService;

import java.util.List;

/**
 * @author ismailibrahim.s@cognizant.com class for provide service to incoming
 *         album related request
 */
@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	/**
	 * List down all albums
	 * 
	 * @param model
	 * @return albums.html
	 * @throws Exception
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("count", albumService.getAlbumList().size());
		return "welcome";
	}

	@RequestMapping(value = "/albumsslow", method = RequestMethod.GET)
	public String listProductsSlow(Model model) throws Exception {
		List<Album> albums = (List<Album>) albumService.getAlbumList();
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
		return "albums";
	}

	/**
	 * List down all albums
	 * 
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public String listProducts(Model model) {
		List<Album> albums = (List<Album>) albumService.getAlbumList();
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
		return "albums";
	}

	/**
	 * deleting the alubums
	 * 
	 * @param id
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/deletealbum", method = RequestMethod.GET)
	public String deleteAlbum(@RequestParam("id") String id, Model model) {
		albumService.removeAlbum(id);
		String actionStr = String.format("Album [%s] successfully deleted", id);

		List<Album> albums = albumService.getAlbumList();

		model.addAttribute("actionStr", actionStr);
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));
		return "albums";
	}

	/**
	 * Adding new album into DB
	 * 
	 * @param model
	 * @return newalbum.html
	 */
	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String addNewAlbum(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		return "newalbum";
	}

	/**
	 * Eding the album
	 * 
	 * @param id
	 * @param model
	 * @return editalbum.html
	 */
	@RequestMapping(value = "/editalbum", method = RequestMethod.GET)
	public String editAlbum(@RequestParam(value = "id", required = true) String id, Model model) {
		Album album = albumService.getAlbum(id);
		model.addAttribute("album", album);
		return "editalbum";
	}

	/**
	 * searching the album from the list
	 * 
	 * @param title
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/searchAlbums", method = RequestMethod.POST)
	public String searchAlbums(@RequestParam(value = "title") String title, Model model) {
		List<Album> albums = albumService.searchAlbums(title);
		model.addAttribute("title", title);
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

		return "albums";
	}

	/**
	 * adding albums
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
	public String addAlbum(@RequestParam(value = "title") String title, @RequestParam(value = "artist") String artist,
			@RequestParam(value = "releaseYear") String releaseYear, Model model) {

		// Album album = new Album(title, artist, releaseYear);
		albumService.saveAlbum(title, artist, releaseYear);

		String actionStr = "Album successfully added";

		List<Album> albums = albumService.getAlbumList();
		model.addAttribute("actionStr", actionStr);
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

		return "albums";
	}

	/**
	 * Editing the album
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @param id
	 * @param model
	 * @return albums.html
	 */
	@RequestMapping(value = "/editAlbum", method = RequestMethod.POST)
	public String editAlbum(@RequestParam(value = "title") String title, @RequestParam(value = "artist") String artist,
			@RequestParam(value = "releaseYear") String releaseYear,
			@RequestParam(value = "id", required = true) String id, Model model) {

		Album album = new Album(title, artist, releaseYear);
		album.setId(id);
		albumService.EditAlbum(id, title, artist, releaseYear);

		String actionStr = String.format("Album [%s] successfully edited", id);

		List<Album> albums = albumService.getAlbumList();
		model.addAttribute("actionStr", actionStr);
		model.addAttribute("albums", albums);
		model.addAttribute("countStr", String.format("Total of %s albums", albums.size()));

		return "albums";
	}
}
