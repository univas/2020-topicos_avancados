package br.edu.univas.si7.lab7.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericJpaDao<T extends Serializable> 

	extends AbstractJpaDao<T> implements IGenericDao<T> {
	
	//
}
