/**
 * 
 */
package com.starterkit.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.starterkit.domain.Person;
import com.starterkit.repository.PersonRepository;

/**
 * @author admin
 *
 */
public class PersonServiceTest {


	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonService personService;
	
	private List<Person> personList = new ArrayList<>();
	 @Before
	    public void setUp() {
		 MockitoAnnotations.initMocks(this);
	 }
	 @Test
	 public void savePersonTest(){
		 Person person = new Person("Rahul", "Dravid");
		 person.setId("RahulId");
		 when(personRepository.save(any(Person.class))).thenReturn(person);
		 Person savedPerson=personService.savePerson("Rahul", "Dravid");
		 Assert.assertTrue(savedPerson.getFirstName()==person.getFirstName());
	 }
	 
	 @Test
	 public void editPersontest(){
		 Person person = new Person("Rahul", "Dravid");
		 person.setId("RahulId");
		 when(personRepository.save(any(Person.class))).thenReturn(person);
		 Assert.assertTrue(personService.editPerson("RahulId", "Rahul", "Dravid"));
	 }
	 
	 @Test
	 public void getPersontest(){
		 Person person = new Person("Rahul", "Dravid");
	      person.setId("RahulId");
	       when(personRepository.findOne("RahulId")).thenReturn(person);
	       Assert.assertEquals(personService.getPerson("RahulId"), person);
	 }
	 
	 @Test
	 public void getAllPersons(){
		 Person person = new Person("Rahul", "Dravid");
		 person.setId("RahulId");
	      Person person2 = new Person("John", "David");
	      person2.setId("JohnId");
	      Person person3 = new Person("Mark", "clint");
	      person3.setId("MarkId");
	      personList.add(person);
	      personList.add(person2);
	      personList.add(person3);
		 when(personRepository.findAll()).thenReturn(personList);
		 Assert.assertArrayEquals(personService.getAllPersons().toArray(), personList.toArray());
	 }
}
