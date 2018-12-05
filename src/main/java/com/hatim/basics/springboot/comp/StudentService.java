package com.hatim.basics.springboot.comp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private Map<Long, Student> data = new HashMap<>(4);

	public StudentService() {
		data.put(Long.valueOf(1),  new Student(1, "Hatim" , "MSB" , "III"));
	}
	
	public Student getStudent(long id) {
		return data.get(id);
	}
	
	public void addStudent(Student s) {
		data.put(s.getId() , s);
	}

	public void removeStudent(long id) {
		data.remove(id);
	}

	public Collection<Student> listStudent() {
		return data.values();
	}
	
}
