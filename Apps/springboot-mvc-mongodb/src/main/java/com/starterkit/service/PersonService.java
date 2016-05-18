/**
 * 
 */
package com.starterkit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.starterkit.domain.Person;
import com.starterkit.repository.PersonRepository;

/**
 * @author admin
 *
 */
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(String firstName,String lastName){
		Person person= new Person(firstName, lastName);
		return personRepository.save(person);
	}
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	public void deletePerson(String id){
		personRepository.delete(id);
	}
	public Person getPerson(String id){
		return personRepository.findOne(id);
	}
	public boolean editPerson(String id,String firstName,String lastName){
		Person person= new Person(firstName, lastName);
		person.setId(id);
		Person editedPerson= personRepository.save(person);
		return person.getId()==editedPerson.getId()?true:false;
	}
}
