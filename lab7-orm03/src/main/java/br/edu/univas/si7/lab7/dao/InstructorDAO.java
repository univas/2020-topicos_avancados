package br.edu.univas.si7.lab7.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Instructor;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class InstructorDAO extends AbstractDAO<Instructor> {

	public InstructorDAO() {
		super.setClazz(Instructor.class);
	}
}