package com.rf.dio.personapigft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.personapigft.dto.response.MessageResponseDTO;
import com.rf.dio.personapigft.entity.Person;
import com.rf.dio.personapigft.service.PersonService;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PersonController {// REPETIR NA API RELATÓRIO

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}

}
