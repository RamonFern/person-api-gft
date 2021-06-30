package com.rf.dio.personapigft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.dio.personapigft.entity.Person;
import com.rf.dio.personapigft.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person person) {
		Person personSave = personRepository.save(person);
		return personSave;
		
	}
	
	

}
