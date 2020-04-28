package br.edu.univas.si7.lab7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.lab7.dao.InstructorDAO;
import br.edu.univas.si7.lab7.entities.Instructor;

@Service
public class InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;

	public void saveInstructor(Instructor instructor) {
		instructorDAO.save(instructor);
	}
}
