package br.edu.univas.si7.lab7.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.lab7.entities.Student;
import br.edu.univas.si7.lab7.rest.support.ResponseStatus;
import br.edu.univas.si7.lab7.rest.support.StudentErrorMessage;
import br.edu.univas.si7.lab7.rest.support.StudentException;
import br.edu.univas.si7.lab7.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRest {

	@Autowired
	private StudentService studentService;

	//Método para retornar 1 objeto Student (POJO) (por enquanto será a Entity do ORM)
	@GetMapping(value = "/fixedStudent")//, produces = MediaType.APPLICATION_XML_VALUE)
	public Student getFixedStudent() {
		
		return new Student(1, "Roberto");
	}
	
	//Método para retornar uma lista de objetos Student
	@GetMapping("/students")
	public List<Student> getAllStudents() {
			
		return studentService.getAllStudents();
	}

	//Método para pegar o student pelo ID
	//o id virá na própria URL
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		
		return studentService.getStudent(id); //TODO: tratar fluxo alternativo (exceção)
	}
	
	//Criar um novo objeto
	@PostMapping("/student") //objeto vai ser recebido via body (do request)
	//o newStudent não deve possuir PK (quando for auto incremento) - usaremos esse
	//o newStudent deve possuir PK (quando não for auto incremento)
	public Student createStudent(@RequestBody Student newStudent) {
		
		return studentService.createStudent(newStudent); //seta o novo id do objeto //TODO: tratar fluxo alternativo (exceção)
	}
	
	//Fazer update
	@PutMapping("/student/{id}")
	public ResponseStatus updateStudent(@PathVariable int id, @RequestBody Student theStudent) {

		return studentService.updateStudent(id, theStudent);//TODO: tratar fluxo alternativo (exceção)
	}
	
	//remover
	@DeleteMapping("/student/{id}")
	public ResponseStatus removeStudent(@PathVariable int id) {

		return studentService.removeStudent(id); //TODO: tratar fluxo alternativo (exceção)
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorMessage> hangleException(StudentException ex) {
		StudentErrorMessage error = new StudentErrorMessage();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
