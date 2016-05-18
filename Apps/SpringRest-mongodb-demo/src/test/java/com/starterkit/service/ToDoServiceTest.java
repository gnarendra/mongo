/**
 * 
 */
package com.starterkit.service;

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
import com.starterkit.domain.ToDo;
import com.starterkit.repository.ToDoRepository;

/**
 * @author Anand.Kittappa@cognizant.com
 *
 */

@SpringApplicationConfiguration(classes = Application.class) // 2
public class ToDoServiceTest {

	@Mock
	private ToDoRepository toDoRepository;

	@InjectMocks
	private ToDoService toDoService;

	private List<ToDo> taskList = new ArrayList<>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveTasktest() {
		ToDo breakfastToDo = new ToDo("breakfast");
		breakfastToDo.setId("breakfastId");
		when(toDoRepository.save(any(ToDo.class))).thenReturn(breakfastToDo);
		boolean flag = toDoService.saveTask("breakfast");
		Assert.assertTrue(flag);

	}

	@Test
	public void getAllTasktest() {
		ToDo breakfastToDo = new ToDo("breakfast");
		breakfastToDo.setId("breakfastId");
		ToDo lunchToDo = new ToDo("lunch");
		lunchToDo.setId("lunchId");
		ToDo dinnerToDo = new ToDo("dinner");
		dinnerToDo.setId("dinnerId");
		taskList.add(breakfastToDo);
		taskList.add(lunchToDo);
		taskList.add(dinnerToDo);
		when(toDoRepository.findAll()).thenReturn(taskList);
		Assert.assertArrayEquals(toDoService.getAllTask().toArray(), taskList.toArray());
	}

	@Test
	public void editTasktest() {
		ToDo breakfastToDo = new ToDo("breakfast");
		breakfastToDo.setId("breakfastId");
		when(toDoRepository.save(any(ToDo.class))).thenReturn(breakfastToDo);
		boolean flag = toDoService.editTask("breakfastId", "breakfast");

		Assert.assertTrue(flag);
	}

	@Test
	public void getTasktest() {
		ToDo breakfastToDo = new ToDo("breakfast");
		breakfastToDo.setId("breakfastId");
		when(toDoRepository.findOne("breakfastId")).thenReturn(breakfastToDo);
		Assert.assertEquals(toDoService.getTask("breakfastId"), breakfastToDo);
	}

}