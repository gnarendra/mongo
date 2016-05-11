package com.staterkit.cloud.webapp.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.staterkit.cloud.webapp.domain.Album;

/**
 * @author narendra.gurram@cognizant.com
 *
 */
public interface JpaAlbumRepository extends JpaRepository<Album, String>
{
    
}
