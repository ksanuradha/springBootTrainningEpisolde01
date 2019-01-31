package com.example.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.repository.PersonRepository;
import com.example.springbootdemo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	
	@RequestMapping("/person")
	public List<Person> getAllPeople() {
		return personService.getAllPassengers();
	}
	
	@PostMapping("/person")
	public Person insertPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@DeleteMapping("/person/{nic}")
	public void deletePeople(@PathVariable String nic) {
		personService.deletePeople(nic);
	}
	
	@PutMapping("/person/{nic}")
	public void updatePerson(@PathVariable String nic,@RequestBody Person person) {
		personService.updatePeople(nic, person);
	}
	
}
