package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PersonDao;
import com.model.Person;

@RestController
public class PersonController {
	@Autowired
	private PersonDao pdao;
	
	@PostMapping("/create")
	public Person createPerson(@RequestBody Person person) {
		return pdao.save(person);
	}
	
	@GetMapping("/getPerson")
		public List<Person> getPerson(Person person) {
			return pdao.findAll();
		}
	
	//getbyID
	@GetMapping("/persons/{id}")
	public Optional<Person> getPersonbyId(@PathVariable("id") Integer id) {
		return pdao.findById(id);
	}
	//delete by ID
	
	@DeleteMapping("/persons/delete/{id}")
	public void deletePersonbyId(@PathVariable("id") Integer id) {
		pdao.deleteById(id);
	}
}
