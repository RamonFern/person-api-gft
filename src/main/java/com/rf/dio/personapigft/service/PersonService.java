package com.rf.dio.personapigft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	

}
