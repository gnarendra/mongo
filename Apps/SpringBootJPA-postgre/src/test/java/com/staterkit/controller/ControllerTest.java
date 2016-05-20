package com.staterkit.controller;
/**
 * 
 */


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.starterkit.controllers.AlbumController;
import com.starterkit.services.AlbumService;



/**
 * @author narendra.gurram@cognizant.com
 *
 */
@SpringApplicationConfiguration(classes = com.starterkit.Application.class)   
public class ControllerTest {

		@Mock
		private JpaRepository jpaAlbumRepository;
		
		@InjectMocks
		private AlbumService albumsService;

		private MockMvc mockMvc;
		
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
			this.mockMvc = MockMvcBuilders.standaloneSetup(new AlbumController()).build();
		}
		 @Test
		 public void getAlbumsTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/albums"));
			
		 }
		 
		 @Test
		 public void deleteAlbumsTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/deletealbum?id=1"));
			
		 }
		 
		 @Test
		 public void addAlbumTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/addAlbum?title=test&artist=test&releaseYear=2016"));
			
		 }
		
		 @Test
		 public void editAlbumTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/editAlbum?id=1&title=test&artist=test&releaseYear=2016"));
			
		 }
		
		 
	}
