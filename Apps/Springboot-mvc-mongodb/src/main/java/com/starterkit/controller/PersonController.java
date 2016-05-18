/**
 * 
 */
package com.starterkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starterkit.domain.Person;
import com.starterkit.dto.PersonDTO;
import com.starterkit.repository.PersonRepository;

/**
 * @author ismailibrahim.s@cognizant.com This person Controller class for
 *         providing service to incoming client requests
 */

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Person createPerson(@RequestBody PersonDTO personDTO) {
		Person person = null;
		if (null != personDTO) {
			person = new Person();
			person.setFirstName(personDTO.getFirstName());
			person.setLastName(personDTO.getLastName());

			person = personRepository.save(person);
		}
		return person;
	}

	public List<Person> getAllPersons() {
		List<Person> listOfPersons = null;
		listOfPersons = personRepository.findAll();
		return listOfPersons;
	}

	/**
	 * This method maps to GET type of HTTP request with /personlist URL. Get
	 * the list of Person from DB by calling the getAllPerson service. Send the
	 * person list as a response
	 * 
	 * @param model
	 * @return personlist
	 */

	@RequestMapping(value = "/personlist", method = RequestMethod.GET)
	public @ResponseBody List<Person> showPersonList(Model model) {
		return getAllPersons();
	}

	/**
	 * This method maps to GET type of HTTP request with /deletePerson URL. Get
	 * the inputs from user via requestparam and delete the person from DB by
	 * calling deletePerson service. Send the task list as a response
	 * 
	 * @param id
	 * @param model
	 * @return index.html
	 */

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public @ResponseBody List<Person> deletePerson(@RequestParam("id") String id, Model model) {
		personRepository.delete(id);
		return getAllPersons();
	}

	/**
	 * This method maps to POST type of HTTP request with /editPerson URL. Get
	 * the inputs from user via requestparam and update the person into DB by
	 * calling editPerson service. Send the task list as a response
	 * 
	 * @param firstName
	 * @param lastName
	 * @param id
	 * @param model
	 * @return index.html
	 */
	@RequestMapping(value = "/editPerson", method = RequestMethod.POST)
	public @ResponseBody List<Person> editPerson(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "id", required = true) String id,
			Model model) {

		Person person = new Person(firstName, lastName);
		person.setId(id);
		personRepository.save(person);
		return getAllPersons();
	}

	/**
	 * This method maps to POST type of HTTP request with /addPerson URL. Get
	 * the inputs from user via requestparam and save the person into DB by
	 * calling save service. Send the task list as a response
	 * 
	 * @param firstName
	 * @param lastName
	 * @param model
	 * @return index.html
	 */

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public @ResponseBody List<Person> addPerson(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, Model model) {

		Person person = new Person(firstName, lastName);
		personRepository.save(person);
		return getAllPersons();
	}

}
