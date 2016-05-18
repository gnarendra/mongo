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
 * @author ismailibrahim.s@cognizant.com Controller class for provide service to
 *         incoming request
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
	 * List the personlist
	 * 
	 * @param model
	 * @return persons.html
	 */

	@RequestMapping(value = "/personlist", method = RequestMethod.GET)
	public @ResponseBody List<Person> showPersonList(Model model) {
		return getAllPersons();
	}

	/**
	 * Delete the person
	 * 
	 * @param model
	 * @return persons.html
	 */

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public @ResponseBody List<Person> deletePerson(@RequestParam("id") String id, Model model) {
		personRepository.delete(id);
		return getAllPersons();
	}

	/**
	 * Edit the person
	 * 
	 * @param fName
	 * @param lName
	 * @return editPerson.html
	 */
	@RequestMapping(value = "/editPerson", method = RequestMethod.POST)
	public @ResponseBody List<Person> editPerson(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "id", required = true) String id, Model model) {

		Person person = new Person(firstName, lastName);
		person.setId(id);
		personRepository.save(person);
		return getAllPersons();
	}

	/**
	 * Add the person
	 * 
	 * @param fName
	 * @param lName
	 * @return persons.html
	 */

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public @ResponseBody List<Person> addPerson(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
			Model model) {

	Person person = new Person(firstName, lastName);
		personRepository.save(person);
		return getAllPersons();
	}
	

}
