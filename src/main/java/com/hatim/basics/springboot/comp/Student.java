package com.hatim.basics.springboot.comp;

public class Student {
	
	private long id;
	private String name;
	private String school;
	private String standard;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, String school, String standard) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
		this.standard = standard;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
	
}
