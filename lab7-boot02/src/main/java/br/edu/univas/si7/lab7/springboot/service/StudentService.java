package br.edu.univas.si7.lab7.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.lab7.springboot.dao.StudentNewDAO;
import br.edu.univas.si7.lab7.springboot.dao.StudentOldDAO;
import br.edu.univas.si7.lab7.springboot.entities.Student;

@Service
public class StudentService {

	@Autowired
//	private StudentOldDAO studentDAO;
	private StudentNewDAO studentDAO;
	
	public List<Student> getAllStudents() {
		return studentDAO.findAll();
	}
}
