package br.edu.univas.si7.lab7.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class StudentRest {

	//lista temporária em memória
	private List<Student> listStudents;

	@PostConstruct //usando para inicalizar a listaf após a criação do serviço REST
	//serve para fazer alguma inicialização desse REST
	private void loadData() {
		System.out.println("Creating student list in memory.");
		listStudents = new ArrayList<Student>();
		listStudents.add(new Student(0, "João"));
		listStudents.add(new Student(1, "Joaquim"));
		listStudents.add(new Student(2, "Júlia"));
	}

	//Método para retornar 1 objeto Student (POJO) (por enquanto será a Entity do ORM)
	@GetMapping(value = "/fixedStudent")//, produces = MediaType.APPLICATION_XML_VALUE)
	public Student getFixedStudent() {
		return new Student(1, "Roberto");
	}
	
	//Método para retornar uma lista de objetos Student
	@GetMapping("/students")
	public List<Student> getAllStudents() {
			
		return listStudents;
	}

	//Método para pegar o student pelo ID
	//o id virá na própria URL
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		return listStudents.get(id); //TODO: tratar fluxo alternativo (exceção)
	}
	
	//Criar um novo objeto
	@PostMapping("/student") //objeto vai ser recebido via body (do request)
	//o newStudent não deve possuir PK (quando for auto incremento) - usaremos esse
	//o newStudent deve possuir PK (quando não for auto incremento)
	public Student createStudent(@RequestBody Student newStudent) {
		newStudent.setRegister(listStudents.size());//seta o novo id do objeto //TODO: tratar fluxo alternativo (exceção)
		listStudents.add(newStudent);
		return newStudent;
	}
	
	//Fazer update
	@PutMapping("/student/{id}")
	public ResponseStatus updateStudent(@PathVariable int id, @RequestBody Student theStudent) {
		Student student = listStudents.get(id); //TODO: tratar fluxo alternativo (exceção)
		student.setName(theStudent.getName());
		return new ResponseStatus(0, "Success updatin student " + id);
	}
	
	//remover
	@DeleteMapping("/student/{id}")
	public ResponseStatus removeStudent(@PathVariable int id) {
		listStudents.remove(id); //TODO: tratar fluxo alternativo (exceção)

		return new ResponseStatus(0, "Success removing student " + id);
	}
}
