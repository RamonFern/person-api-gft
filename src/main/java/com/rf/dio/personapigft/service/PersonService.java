package com.rf.dio.personapigft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rf.dio.personapigft.entity.Person;
import com.rf.dio.personapigft.exceptions.PersonNotFoundException;
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
	
	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		personRepository.deleteById(id);
	}
	
	@Transactional
	public Person update(Long id, Person person) {
		Person personUpdate = findById(id);
		personUpdate.setPrimeiroNome(person.getPrimeiroNome());
		personUpdate.setUltimoNome(person.getUltimoNome());
		personUpdate.setCpf(person.getCpf());
		personUpdate.setDataNiver(person.getDataNiver());
		personUpdate.setPhones(person.getPhones());

		personRepository.save(personUpdate);
		return personUpdate;
	}

}
