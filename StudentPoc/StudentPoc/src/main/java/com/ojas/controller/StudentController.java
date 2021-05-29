package com.ojas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Student;
import com.ojas.service.StudentService;

@RestController
@RequestMapping("/app/student") 
public class StudentController {
	
	@Autowired
	StudentService stdser;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return stdser.createStudent(student);
	}
	@GetMapping("/student/{stdId}")
	public Optional<Student> getById(@PathVariable("stdId") Integer stdId) {
		return stdser.getById(stdId);
	}
}
