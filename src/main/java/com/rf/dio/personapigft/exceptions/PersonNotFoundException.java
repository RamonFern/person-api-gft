package com.rf.dio.personapigft.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(Long id) {
        super("Pessoa não existe com Id: " + id);
    }

}
