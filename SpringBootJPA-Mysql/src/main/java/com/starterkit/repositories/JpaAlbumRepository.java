package com.starterkit.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.starterkit.domain.Album;

/**
 * @author ismailibrahim.s@cognizant.com
 * Searching album by title
 */
public interface JpaAlbumRepository extends JpaRepository<Album, String>
{
    @Query("select a from Album a where a.title like %?1%")
    List<Album> findByTitleContains(String title);
}
