package com.rf.dio.personapigft.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rf.dio.personapigft.dto.PersonDTO;
import com.rf.dio.personapigft.entity.Person;

@Component
public class PersonMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public Person toPerson(PersonDTO dto) {
		return MODEL_MAPPER.map(dto, Person.class);
	}

	public PersonDTO toDTO(Person person) {
		return MODEL_MAPPER.map(person, PersonDTO.class);
	}
}
