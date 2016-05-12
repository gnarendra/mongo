package com.starterkit.controller;

import java.util.ArrayList;

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
	private ToDoService ToDoService;

	/**
	 * Get the list task while application start up
	 * 
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getAllTask(Model model) {
		return new ModelAndView("todo", "tasks", ToDoService.getAllTask());
	}

	/**
	 * Creating a new Task
	 * 
	 * @param model
	 * @return addtask.html
	 */
	@RequestMapping(value = "/CreateTask", method = RequestMethod.GET)
	public ModelAndView createTask(Model model) {
		ToDo todo = new ToDo();
		return new ModelAndView("addTask", "ToDo", todo);
	}

	/**
	 * Get the input from user and add the task to DB
	 * 
	 * @param TName
	 * @param Tdescription
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/addTodo", method = RequestMethod.POST)
	public ModelAndView addTask(@RequestParam(value = "TName") String taskName,
			@RequestParam(value = "Tdescription") String taskDescription, Model model) {

		if (ToDoService.saveTask(taskName, taskDescription)) {
			return new ModelAndView("todo", "tasks", ToDoService.getAllTask());
		} else {
			return new ModelAndView("todo", "tasks", new ArrayList<>());
		}
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
	@RequestMapping(value = "/editTodo", method = RequestMethod.POST)
	public ModelAndView editTodo(@RequestParam(value = "TName") String taskName,
			@RequestParam(value = "Tdescription") String taskDescription, @RequestParam("id") String id, Model model) {

		if (ToDoService.editTask(id, taskName, taskDescription)) {
			return new ModelAndView("todo", "tasks", ToDoService.getAllTask());
		} else {
			return new ModelAndView("todo", "tasks", new ArrayList<>());
		}
	}

	/**
	 * Delete the task from task
	 * 
	 * @param id
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public ModelAndView deleteTask(@RequestParam("id") String id, Model model) {
		ToDoService.removetask(id);
		return new ModelAndView("todo", "tasks", ToDoService.getAllTask());
	}

	/**
	 * forward edit request to html page
	 * 
	 * @param id
	 * @param model
	 * @return edittask.html
	 */
	@RequestMapping(value = "/EditTask", method = RequestMethod.GET)
	public ModelAndView editTask(@RequestParam(value = "id", required = true) String id, Model model) {
		return new ModelAndView("editTask", "ToDo", ToDoService.getTask(id));
	}

}
