package br.edu.univas.si7.lab7.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.lab7.entities.Student;

@RestController
@RequestMapping("/api")
public class HelloRest {

private List<Student> studentList;
	
	@PostConstruct
	public void loadData() {
		System.out.println("Inside loadData()");
		// criar uma lista fixa de objetos Student
		studentList = new ArrayList<Student>();
		studentList.add(new Student(0, "João"));
		studentList.add(new Student(1, "Joaquim"));
		studentList.add(new Student(2, "Júlia"));
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}

}
