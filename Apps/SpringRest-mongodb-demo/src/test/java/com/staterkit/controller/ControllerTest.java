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

import com.starterkit.Application;
import com.starterkit.controller.ToDoController;
import com.starterkit.repository.ToDoRepository;
import com.starterkit.service.ToDoService;



/**
 * @author narendra.gurram@cognizant.com
 *
 */
@SpringApplicationConfiguration(classes = Application.class)   
public class ControllerTest {

	@Mock
	private ToDoRepository toDoRepository;

	@InjectMocks
	private ToDoService toDoService;

		private MockMvc mockMvc;
		
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
			this.mockMvc = MockMvcBuilders.standaloneSetup(new ToDoController()).build();
		}
		 @Test
		 public void getTasksTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/tasks"));
			
		 }
		 
		 @Test
		 public void deleteTaskTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/deleteTask?id=1"));
			
		 }
		 
		 @Test
		 public void addTaskTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/createTask?taskName=test"));
		 }
		
		 @Test
		 public void editTaskTest	() throws Exception{
			 this.mockMvc.perform(MockMvcRequestBuilders.post("/editTask?id=1&taskName=test"));
			
		 }
		
		 
	}
