package br.edu.univas.si7.lab7.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Instructor;

@Repository
public class InstructorDAO {

	@Autowired
	private EntityManager em;

	//métodos de Instructor
	public void saveInstructor(Instructor instructor) {
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
	}

	public void updateInstructor(Instructor instructor) {
		em.getTransaction().begin();
		em.merge(instructor);
		em.getTransaction().commit();
	}

	public List<Instructor> listAllInstructors() {
		return em.createQuery("select s from Instructor s", Instructor.class).getResultList();
	}

	public Instructor findInstructorById(int reg) {
		return em.find(Instructor.class, reg);
	}

	public List<Instructor> findInstructorByName(String name) {
		TypedQuery<Instructor> query = em.createNamedQuery("Instructor.findByName", Instructor.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	public void removeInstructor(int registration) {
		em.getTransaction().begin();
		Instructor instructorToRemove = findInstructorById(registration);
		if (instructorToRemove != null) {
			em.remove(instructorToRemove);
		}
		em.getTransaction().commit();
	}
}
