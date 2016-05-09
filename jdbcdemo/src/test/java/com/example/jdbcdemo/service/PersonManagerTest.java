package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Person;

public class PersonManagerTest {
	
	
	PersonManager personManager = new PersonManager();
	
	private final static String NAME_1 = "Zenek";
	private final static String NAME_2 = "Gustaw";
	private final static String NAME_3 = "Zenobiusz";
	private final static int YOB_1 = 1945;
	private final static int YOB_2 = 1950;
	private final static int YOB_3 = 1955;
	
	@Test
	public void checkConnection(){
		assertNotNull(personManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Person person = new Person(NAME_1, YOB_1);
		
		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));
		
		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);
		
		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());
		
	}

	@Test
	public void checkDeleting(){
		Person person1 = new Person(NAME_1, YOB_1);
		Person person2 = new Person(NAME_2, YOB_2);
		Person person3 = new Person(NAME_3, YOB_3);
		personManager.clearPersons();
		personManager.getAllPersons();
		assertEquals(1,personManager.addPerson(person1));
		assertEquals(1,personManager.addPerson(person2));
		assertEquals(1,personManager.addPerson(person3));

		personManager.deletePerson(person2);

	}

}
