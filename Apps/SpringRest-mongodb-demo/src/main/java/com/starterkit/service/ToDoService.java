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
	 * Get all the task from 'ToDo' collection by calling the findAll method
	 * @return List of task
	 */
	public List<ToDo> getAllTask(){
		return toDoRepository.findAll();
	}
	
	/**
	 * Save new task into 'ToDo' collection by calling the save method
	 * @param taskName
	 * @param taskDescription
	 */
	public boolean saveTask(String taskName){
		ToDo todo = new ToDo(taskName);
		ToDo savedTodo = toDoRepository.save(todo);
		return todo.getTaskName().equalsIgnoreCase(savedTodo.getTaskName())?true:false;
	}
	/**
	 * Updated the task into 'ToDo' collection by saving the task based on task id 
	 * @param taskId
	 * @param taskName
	 * @param taskDescription
	 */
	public boolean editTask(String taskId,String taskName){
		ToDo todo = new ToDo(taskName);
		todo.setId(taskId);
		ToDo savedTodo = toDoRepository.save(todo);
		return todo.getId().equalsIgnoreCase(savedTodo.getId())?true:false;
	}
	
	/**
	 * Remove the task from 'ToDo' collection by calling delete method
	 * @param taskId
	 */
	public void removetask(String taskId){
		toDoRepository.delete(taskId);
	}
	/**
	 * Get a particular task from 'ToDo' collection by calling findOne method with task Id
	 * @param taskId
	 * @return
	 */
	public ToDo getTask(String taskId){
		return toDoRepository.findOne(taskId);
	}

}
