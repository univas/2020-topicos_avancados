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
	public void save(Instructor instructor) {
		em.getTransaction().begin();
		em.persist(instructor);
		em.getTransaction().commit();
	}

	public void update(Instructor instructor) {
		em.getTransaction().begin();
		em.merge(instructor);
		em.getTransaction().commit();
	}

	public List<Instructor> listAll() {
		return em.createQuery("select s from Instructor s", Instructor.class).getResultList();
	}

	public Instructor findById(int reg) {
		return em.find(Instructor.class, reg);
	}

	public List<Instructor> findByName(String name) {
		TypedQuery<Instructor> query = em.createNamedQuery("Instructor.findByName", Instructor.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	public void remove(int registration) {
		em.getTransaction().begin();
		Instructor instructorToRemove = findById(registration);
		if (instructorToRemove != null) {
			em.remove(instructorToRemove);
		}
		em.getTransaction().commit();
	}
}
