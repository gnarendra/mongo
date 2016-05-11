/**
 * 
 */
package com.starterkit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showPersonList(Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "persons";
	}

	/**
	 * Delete the person
	 * 
	 * @param model
	 * @return persons.html
	 */

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public String deletePerson(@RequestParam("id") String id, Model model) {
		personRepository.delete(id);
		model.addAttribute("persons", personRepository.findAll());
		return "persons";
	}

	/**
	 * Edit the person
	 * 
	 * @param model
	 * @return editPerson.html
	 */
	@RequestMapping(value = "/EditPerson", method = RequestMethod.GET)
	public String editAlbum(@RequestParam(value = "id", required = true) String id, Model model) {
		Person person = personRepository.findOne(id);
		model.addAttribute("person", person);
		return "editPerson";
	}

	/**
	 * Edit the person
	 * 
	 * @param fName
	 * @param lName
	 * @return editPerson.html
	 */
	@RequestMapping(value = "/EditPerson", method = RequestMethod.POST)
	public String editPerson(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName,
			@RequestParam(value = "id", required = true) String id, Model model) {

		Person person = new Person(fName, lName);
		person.setId(id);
		personRepository.save(person);
		model.addAttribute("persons", personRepository.findAll());
		return "persons";
	}

	/**
	 * Add the person
	 * 
	 * @param fName
	 * @param lName
	 * @return persons.html
	 */

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String addPerson(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName,
			Model model) {

	Person person = new Person(fName, lName);
		personRepository.save(person);
		model.addAttribute("persons", personRepository.findAll());
		return "persons";
	}

	/**
	 * forward to the createPerson page
	 * 
	 * @return createPerson.html
	 */

	@RequestMapping(value = "/CreatePerson", method = RequestMethod.GET)
	public String addNewAlbum(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "createPerson";
	}

}
