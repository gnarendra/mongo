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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.starterkit.controller.PersonController;
import com.starterkit.repository.PersonRepository;
import com.starterkit.service.PersonService;





/**
 * @author narendra.gurram@cognizant.com
 *
 */
@SpringApplicationConfiguration(classes = com.starterkit.Application.class)   
public class ControllerTest {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonService personService;

		private MockMvc mockMvc;
		
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
			this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
		}
		 @Test
		 public void getPersonListTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/person/personlist"));
			
		 }
		 
		 @Test
		 public void deletePersonTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/person/deletePerson?id=1"));
		
		 }
		 
		 @Test
		 public void addPersonTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/person/addPerson?firstName=test&lastName=test"));
			
		 }
		
		 @Test
		 public void editPersonTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/person/editPerson?id=1&firstName=test&lastName=test"));
			
		 }
		
		 
	}
