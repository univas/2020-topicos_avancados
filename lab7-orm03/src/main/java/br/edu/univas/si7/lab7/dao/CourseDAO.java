package br.edu.univas.si7.lab7.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Course;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CourseDAO extends AbstractDAO<Course> {

	public CourseDAO() {
		super.setClazz(Course.class);
	}
}