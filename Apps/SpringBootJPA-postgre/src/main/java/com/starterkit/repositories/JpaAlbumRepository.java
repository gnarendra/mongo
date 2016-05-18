package com.starterkit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.starterkit.domain.Album;

/**
 * @author Anand.Kittappa@cognizant.com JpaRepository reads system environment
 *         variables (VCAP_SERVICE) and establish a connection with DB using
 *         connection parameters. It creates a table 'Album' (domain class
 *         passed as an argument). Its having build-in methods for CRUD
 *         operation.
 *
 */
public interface JpaAlbumRepository extends JpaRepository<Album, String> {
	/**
	 * Searching album by title
	 * 
	 * @param title
	 * @return
	 */
	@Query("select a from Album a where a.title like %?1%")
	List<Album> findByTitleContains(String title);

}
