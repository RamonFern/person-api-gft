package com.rf.dio.personapigft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rf.dio.personapigft.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
