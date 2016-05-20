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
 * @author Anand.Kittappa@cognizant.com This Todo rest controller class for
 *         providing service to incoming client requests
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
	 * This method maps to GET type of HTTP request with /tasks URL. Get the list
	 * of tasks from DB by calling the getAllTask service. Send the task list as
	 * a response
	 * 
	 * @param model
	 * @return tasks
	 */
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<ToDo> listTasks(Model model) {
		if(toDoService != null){
			List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
			return tasks;
		}else{
			return new ArrayList<ToDo>();
		}
		

	}

	/**
	 * This method maps to POST type of HTTP request with /createTask URL. Get
	 * the inputs from user via requestparam and save the task into DB by calling
	 * saveTask service. Send the task list as a response
	 * 
	 * @param TName
	 * @param Tdescription
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public List<ToDo> addTask(@RequestParam(value = "taskName") String taskName, Model model) {
		if(toDoService !=null){
			toDoService.saveTask(taskName);
			List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
			return tasks;
		}else{
			return new ArrayList<ToDo>();
		}
		

	}

	/**
	 * This method maps to POST type of HTTP request with /editTask URL. Get the
	 * inputs from user via requestparam and update the task into DB by calling
	 * editTask service. Send the task list as a response
	 * 
	 * @param TName
	 * @param Tdescription
	 * @param id
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/editTask", method = RequestMethod.POST)
	public List<ToDo> editTodo(@RequestParam(value = "taskName") String taskName, @RequestParam("id") String id,
			Model model) {
		if(toDoService != null){
			toDoService.editTask(id, taskName);
			List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
			return tasks;
		}else{
			return new ArrayList<ToDo>();
		}
	}

	/**
	 * This method maps to GET type of HTTP request with /deleteTask URL. Get the
	 * inputs from user via requestparam and delete the task from DB by calling
	 * removetask service. Send the task list as a response
	 * 
	 * @param id
	 * @param model
	 * @return todo.html
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public List<ToDo> deleteTask(@RequestParam("id") String id, Model model) {
		if(toDoService != null){
			toDoService.removetask(id);
			List<ToDo> tasks = (List<ToDo>) toDoService.getAllTask();
			return tasks;
		}else{
			return new ArrayList<ToDo>();
		}
	}

}
