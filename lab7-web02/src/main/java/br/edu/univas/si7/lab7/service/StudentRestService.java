package br.edu.univas.si7.lab7.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.lab7.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentRestService {

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
	
	@GetMapping("/students") // endpoint for "students"
	public List<Student> getStudents() {
		return studentList;
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId >= studentList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found - " + studentId);
		}
		Student student = studentList.get(studentId);
		return student;
	}
	
	//exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException ex) {
		//create StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//movido para a classe StudentRestGlobalExceptionHandler
//	//handle generic exceptions
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception ex) {
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(ex.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
}
