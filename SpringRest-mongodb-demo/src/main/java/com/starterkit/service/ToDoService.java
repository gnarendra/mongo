/**
 * 
 */
package com.starterkit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starterkit.domain.ToDo;
import com.starterkit.repository.ToDoRepository;



/**
 * @author Anand.Kittappa@cognizant.com
 *
 */
@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	/**
	 * Get all the task from DB 
	 * @return List of task
	 */
	public List<ToDo> getAllTask(){
		return toDoRepository.findAll();
	}
	
	/**
	 * Save new task
	 * @param taskName
	 * @param taskDescription
	 */
	public boolean saveTask(String taskName,String taskDescription){
		ToDo todo = new ToDo(taskName, taskDescription);
		ToDo savedTodo = toDoRepository.save(todo);
		return todo.getTaskName().equalsIgnoreCase(savedTodo.getTaskName())?true:false;
	}
	/**
	 * Edit the task based on task id
	 * @param taskId
	 * @param taskName
	 * @param taskDescription
	 */
	public boolean editTask(String taskId,String taskName,String taskDescription){
		ToDo todo = new ToDo(taskName, taskDescription);
		todo.setId(taskId);
		ToDo savedTodo = toDoRepository.save(todo);
		return todo.getId().equalsIgnoreCase(savedTodo.getId())?true:false;
	}
	
	/**
	 * Removing the task from task list
	 * @param taskId
	 */
	public void removetask(String taskId){
		toDoRepository.delete(taskId);
	}
	/**
	 * Get the task based on task Id
	 * @param taskId
	 * @return
	 */
	public ToDo getTask(String taskId){
		return toDoRepository.findOne(taskId);
	}

}
