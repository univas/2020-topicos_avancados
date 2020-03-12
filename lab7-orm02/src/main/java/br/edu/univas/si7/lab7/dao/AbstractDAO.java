package br.edu.univas.si7.lab7.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Student;

@Repository
public abstract class AbstractDAO<T, PK> {

	@Autowired
	private EntityManager em;

	//métodos de Student
	public void saveStudent(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	public void modivyStudent(Student student) {
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
	}

	public List<Student> listAllStudents() {
		return em.createQuery("select s from Student s", Student.class).getResultList();
	}

	public Student findStudentById(int reg) {
		return em.find(Student.class, reg);
	}

	public void removeStudent(int register) {
		em.getTransaction().begin();
		Student studentToRemove = findStudentById(register);
		if (studentToRemove != null) {
			em.remove(studentToRemove);
		}
		em.getTransaction().commit();
	}
}
