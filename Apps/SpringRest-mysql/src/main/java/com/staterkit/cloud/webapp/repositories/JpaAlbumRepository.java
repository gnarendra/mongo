package com.staterkit.cloud.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staterkit.cloud.webapp.domain.Album;

/**
 * @author narendra.gurram@cognizant.com.JpaRepository reads system environment
 *         variables (VCAP_SERVICE) and establish a connection with DB using
 *         connection parameters. It creates a table 'Album' (domain class
 *         passed as an argument). Its having build-in methods for CRUD
 *         operation.
 *
 */
public interface JpaAlbumRepository extends JpaRepository<Album, Long> {

}
