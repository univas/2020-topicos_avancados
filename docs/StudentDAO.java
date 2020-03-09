package br.edu.univas.si7.lab7.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Student;

@Repository
public class StudentDAO {

	@Autowired
	private EntityManager em;

	public void save(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	public void altera(Student student) {
		em.merge(student);
	}

	public List<Student> listAll() {
		return em.createQuery("select s from Student s", Student.class).getResultList();
	}

	public Student findById(int reg) {
		return em.find(Student.class, reg);
	}

	public void remove(Student student) {
		Student studentToRemove = findById(student.getRegistration());
		em.remove(studentToRemove);
	}
}
