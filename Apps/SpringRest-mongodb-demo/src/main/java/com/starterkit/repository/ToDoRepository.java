/**
 * 
 */
package com.starterkit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starterkit.domain.ToDo;

/**
 * @author Anand.Kittappa@cognizant.com. MongoRepository reads system environment
 *         variables (VCAP_SERVICE) and establish a connection with DB using
 *         connection parameters. It creates a collection 'ToDo' (domain class passed
 *         as an argument). Its having build-in methods for CRUD operation.
 */
public interface ToDoRepository extends MongoRepository<ToDo, String> {

}
