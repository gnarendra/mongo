/**
 * 
 */
package com.starterkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starterkit.domain.Album;
import com.starterkit.repositories.JpaAlbumRepository;

/**
 * @author ismailibrahim.s@cognizant.com
 *
 */
@Service
public class AlbumService {

	@Autowired
	private JpaAlbumRepository jpaAlbumRepository;

	
	/**
	 * Getting all albums from DB
	 * 
	 * @return List of Albums
	 */
	public List<Album> getAlbumList() {
		return (List<Album>) jpaAlbumRepository.findAll();
	}

	/**
	 * Removing albums from the List
	 * 
	 * @param albumId
	 */
	public void removeAlbum(String albumId) {
		jpaAlbumRepository.delete(albumId);
	}

	/**
	 * Search the album based on tittle
	 * 
	 * @param albumTitle
	 * @return matching album List
	 */
	public List<Album> searchAlbums(String albumTitle) {
		return jpaAlbumRepository.findByTitleContains(albumTitle);
	}

	/**
	 * Save the albums
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return boolean
	 */
	public boolean saveAlbum(String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		Album savedAlbum = jpaAlbumRepository.save(album);
		return album.getTitle() == savedAlbum.getTitle() ? true : false;
	}

	/**
	 * Edit an album
	 * 
	 * @param id
	 * @param title
	 * @param artist
	 * @param releaseYear
	 * @return
	 */
	public boolean EditAlbum(String id, String title, String artist, String releaseYear) {
		Album album = new Album(title, artist, releaseYear);
		album.setId(id);
		Album savedAlbum = jpaAlbumRepository.save(album);
		return album.getId() == savedAlbum.getId() ? true : false;
	}

	/**
	 * Get album based on Id
	 * 
	 * @param id
	 * @return
	 */
	public Album getAlbum(String id) {
		return jpaAlbumRepository.findOne(id);
	}
}
