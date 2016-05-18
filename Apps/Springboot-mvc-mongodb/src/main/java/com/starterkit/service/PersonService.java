/**
 * 
 */
package com.starterkit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.starterkit.domain.Person;
import com.starterkit.repository.PersonRepository;

/**
 * @author ismailibrahim.s@cognizant.com
 *
 */
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Save new task into 'Person' collection by calling the save method
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person savePerson(String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		return personRepository.save(person);
	}

	/**
	 * Get all the person from 'Person' collection by calling the findAll method
	 * 
	 * @return List of persons
	 */
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	/**
	 * Remove the person from 'Person' collection by calling delete method
	 * 
	 * @param id
	 */
	public void deletePerson(String id) {
		personRepository.delete(id);
	}

	/**
	 * Get a particular person from 'Person' collection by calling findOne
	 * method with Id
	 * 
	 * @param id
	 * @return
	 */
	public Person getPerson(String id) {
		return personRepository.findOne(id);
	}

	/**
	 * Updated the task into 'Person' collection by saving the person based on
	 * id
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public boolean editPerson(String id, String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		person.setId(id);
		Person editedPerson = personRepository.save(person);
		return person.getId().equalsIgnoreCase(editedPerson.getId()) ? true : false;
	}
}
