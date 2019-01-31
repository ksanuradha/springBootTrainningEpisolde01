package com.example.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPassengers() {
		return personRepository.findAll();
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public void deletePeople(String nic) {
		personRepository.findById(nic).map(person -> {
			personRepository.delete(person);
			return ResponseEntity.ok().build();
	});
	}	
	 public void updatePeople(String nic,Person person) {
		personRepository.findById(nic).map(personUpdated -> {
			personUpdated.setName(person.getName());
			personUpdated.setAddress(person.getAddress());
			personUpdated.setTelphone(person.getTelphone());
		    	return personRepository.save(personUpdated);
		});
	}
}
