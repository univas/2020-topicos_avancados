package br.edu.univas.si7.lab7.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Student;

@Repository
public class StudentMemoryDAO {

	private Map<Integer, Student> studentList = new HashMap<>();

	public void save(Student student) {
		studentList.put(student.getRegister(), student);
	}

	public void update(Student student) {
		studentList.put(student.getRegister(), student);
	}

	public List<Student> listAll() {
		return new ArrayList<Student>(studentList.values());
	}

	public Student findById(int register) {
		return studentList.get(register);
	}

	public void remove(int register) {
		studentList.remove(register);
	}

	public void remove(Student toRemove) {
		remove(toRemove.getRegister());
	}
}
