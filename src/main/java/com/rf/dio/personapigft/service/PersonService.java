package com.rf.dio.personapigft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.dio.personapigft.dto.response.MessageResponseDTO;
import com.rf.dio.personapigft.entity.Person;
import com.rf.dio.personapigft.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person personSave = personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Pessoa criada com id = " + personSave.getId())
				.build();
		
	}
	
	

}
