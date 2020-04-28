package br.edu.univas.si7.lab7.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.lab7.entities.Review;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ReviewDAO extends AbstractDAO<Review> {

	public ReviewDAO() {
		super.setClazz(Review.class);
	}
}