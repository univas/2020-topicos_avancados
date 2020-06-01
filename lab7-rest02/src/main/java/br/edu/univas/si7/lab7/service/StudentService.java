package br.edu.univas.si7.lab7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.lab7.dao.StudentDAO;
import br.edu.univas.si7.lab7.entities.Student;
import br.edu.univas.si7.lab7.rest.ResponseStatus;
import br.edu.univas.si7.lab7.rest.support.StudentException;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> getAllStudents() {
		return studentDAO.listAll();
	}
	
	public Student getStudent(int id) {
		Student student = studentDAO.findById(id);
		
		if(student == null) { //não achou
			throw new StudentException("Student not found for create: " + id);
		}
		return student;
	}
	
	public Student createStudent(Student newStudent) {
		try {
			studentDAO.save(newStudent);
		} catch(Exception e) {
			throw new StudentException("Error creating new student: " + newStudent, e);
		}
		return newStudent;
	}
	
	public ResponseStatus updateStudent(int id,  Student theStudent) {
		Student toUpdate = studentDAO.findById(id);
		if(toUpdate == null) {
			throw new StudentException("Student not found for update: " + id);
		}
		
		toUpdate.setName(theStudent.getName());
		studentDAO.update(toUpdate);
		return new ResponseStatus(ResponseStatus.STATUS.OK.ordinal(), "Update success for student: " + id);
	}
	
	public ResponseStatus removeStudent(int id) {
		Student toRemove = studentDAO.findById(id);
		if(toRemove == null) {
			throw new StudentException("Student not found for remove: " + id);
		}
		studentDAO.remove(toRemove);
		return new ResponseStatus(ResponseStatus.STATUS.OK.ordinal(), "Remove success for student: " + id);
	}
}
