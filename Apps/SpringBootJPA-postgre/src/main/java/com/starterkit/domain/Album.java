package com.starterkit.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "com.starterkit.domain.RandomIdGenerator")
	private String id;

	private String title;
	private String artist;
	private String releaseYear;

	public Album() {
	}

	/**
	 * Album constructor
	 * 
	 * @param title
	 * @param artist
	 * @param releaseYear
	 */
	public Album(String title, String artist, String releaseYear) {
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
	}

	/**
	 * Get id
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get title
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get artist
	 * 
	 * @return
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Set artist
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Get release year
	 * 
	 * @return
	 */
	public String getReleaseYear() {
		return releaseYear;
	}

	/**
	 * Set release year
	 * 
	 * @param releaseYear
	 */
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Album{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", artist='" + artist + '\''
				+ ", releaseYear='" + releaseYear + '\'' + '}';
	}
}
