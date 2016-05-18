package com.starterkit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.starterkit.domain.ToDo;
import com.starterkit.service.ToDoService;

/**
 * @author Anand.Kittappa@cognizant.com Reset controller class for provide
 *         service to incoming request
 */
@RestController
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	/**
	 * Default welcome file
	 * 
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getAllTask(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("todo");
		return view;
	}

	/**
	 * List down all tasks
	 * 
	 * @param model
	 * @return albums
	 */
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<ToDo> listTasks(Model model) {
		List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
		return tasks;

	}

	
	/**
	 * Get the input from user and add the task to DB
	 * 
	 * @param TName
	 * @param Tdescription
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public List<ToDo> addTask(@RequestParam(value = "taskName") String taskName,
			Model model) {
		toDoService.saveTask(taskName);
		List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
		return tasks;
			
	}

	/**
	 * Get the input from user to update the task to DB
	 * 
	 * @param TName
	 * @param Tdescription
	 * @param id
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/editTask", method = RequestMethod.POST)
	public List<ToDo> editTodo(@RequestParam(value = "taskName") String taskName,
			@RequestParam("id") String id, Model model) {
		toDoService.editTask(id, taskName);
		List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
		return tasks;
	}

	/**
	 * Delete the task from task
	 * 
	 * @param id
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public List<ToDo> deleteTask(@RequestParam("id") String id, Model model) {
		toDoService.removetask(id);
		List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
		return tasks;
	}

	

}
