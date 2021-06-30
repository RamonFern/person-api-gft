package com.rf.dio.personapigft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rf.dio.personapigft.dto.PersonDTO;
import com.rf.dio.personapigft.entity.Person;
import com.rf.dio.personapigft.mapper.PersonMapper;
import com.rf.dio.personapigft.service.PersonService;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PersonController {// REPETIR NA API RELATÓRIO MÉTODO CREATE 

	private final PersonService personService;
	private final PersonMapper personMapper;

	@Autowired
	public PersonController(PersonService personService, PersonMapper personMapper) {
		this.personService = personService;
		this.personMapper = personMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDto) {
		Person personCriada = personMapper.toPerson(personDto);
		Person person = personService.createPerson(personCriada);
		PersonDTO pessoaDto = personMapper.toDTO(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll(){
		List<Person> pessoaList = personService.findAll();
		List<PersonDTO> pessoaDTOList = personMapper.toPessoaDTOList(pessoaList);
		return ResponseEntity.ok(pessoaDTOList);
	}
	
	
}
