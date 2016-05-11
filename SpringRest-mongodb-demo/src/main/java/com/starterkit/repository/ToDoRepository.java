/**
 * 
 */
package com.starterkit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starterkit.domain.ToDo;

/**
 * @author Anand.Kittappa@cognizant.com
 * creating DB and establishing connection
 */
public interface ToDoRepository extends MongoRepository<ToDo, String>{

}
