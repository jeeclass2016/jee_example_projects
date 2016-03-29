package com.vietsci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	@Resource(name=("student1")
	public void setStudent(Student student) {
		this.student = student;
	}

	public Profile() {
		System.out.println("Inside Profile constructor.");
	}

	public void printAge() {
		System.out.println("Age : " + student.getAge());
	}

	public void printName() {
		System.out.println("Name : " + student.getName());
	}

}
