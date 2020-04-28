package br.edu.univas.si7.lab7.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.InstructorDetail;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class InstructorDetailDAO extends AbstractDAO<InstructorDetail> {

	public InstructorDetailDAO() {
		super.setClazz(InstructorDetail.class);
	}
}