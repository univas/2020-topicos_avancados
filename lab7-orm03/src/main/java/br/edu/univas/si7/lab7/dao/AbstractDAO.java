package br.edu.univas.si7.lab7.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T extends Serializable> {

	@Autowired
	EntityManager entityManager;
	
	private Class<T> clazz;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}
	
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	public void save(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}
	
	public void delete(T entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}
	
	public void deleteById(Long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}