package com.hatim.basics.springboot.comp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(path="/{id}")
	public Student getStudent(@PathVariable long id) {
		return service.getStudent(id);
	}
	
	@GetMapping(path="/all")
	public Collection<Student> listStudent() {
		return service.listStudent();
	}
	
	//@PostMapping(path="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(path="/add")
	public String addStudent(Student student) {
		service.addStudent(student);
		return "Done";
	}
	
	@PostMapping(path="/remove")
	public String removeStudent(long id) {
		service.removeStudent(id);
		return "Done";
	}
	
}
