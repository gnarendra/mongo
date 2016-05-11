/**
 * 
 */
package com.starterkit.services;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.starterkit.Application;
import com.starterkit.domain.Album;
import com.starterkit.repositories.JpaAlbumRepository;

/**
 * @author Anand.Kittappa@cognizant.com
 *
 */
@SpringApplicationConfiguration(classes = Application.class)   
public class AlbumsServiceTest {

		@Mock
		private JpaAlbumRepository jpaAlbumRepository;

		@InjectMocks
		private AlbumService albumsService;
		
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}
		 @Test
		 public void saveAlbumTest(){
			 Album album = new Album("yalini", "Anand", "1989");
			 album.setId("yaliniId");
			 when(jpaAlbumRepository.save(any(Album.class))).thenReturn(album);
			 boolean flag=albumsService.saveAlbum("yalini", "Anand", "1989");
			 Assert.assertTrue(flag);
		 }
		 @Test
		 public void getAlbumListTest(){
			 Album yaliniAlbum = new Album("Yalini", "Anand", "1989");
			 yaliniAlbum.setId("yaliniId");
			 Album azhahiAlbum = new Album("Azhahi", "Anand", "1989");
			 azhahiAlbum.setId("AzhahiId");
		     List<Album> albumList=new ArrayList<Album>();
		     albumList.add(azhahiAlbum);
		     albumList.add(yaliniAlbum);
			 when(jpaAlbumRepository.findAll()).thenReturn(albumList);
			 Assert.assertArrayEquals(albumsService.getAlbumList().toArray(), albumList.toArray());
		 }
		 @Test
		 public void searchAlbumstest(){
			 Album yaliniAlbum = new Album("Yalini", "Anand", "1989");
			 yaliniAlbum.setId("yaliniId"); 
			 List<Album> albumList=new ArrayList<Album>();
		     albumList.add(yaliniAlbum);
			 when(jpaAlbumRepository.findByTitleContains("Yalini")).thenReturn(albumList);
			 Assert.assertArrayEquals(albumsService.searchAlbums("Yalini").toArray(), albumList.toArray());
		 }
		 @Test
		 public void editTasktest(){
			 Album yaliniAlbum = new Album("Yalini", "Anand", "1989");
			 yaliniAlbum.setId("yaliniId"); 
			 when(jpaAlbumRepository.save(any(Album.class))).thenReturn(yaliniAlbum);
			// doNothing().when(toDoRepository).save(any(ToDo.class));
			 boolean flag=albumsService.EditAlbum("yaliniId", "Yalini", "Anand","1989");
					 
			 Assert.assertTrue(flag);
		 }
		
		 
	}
