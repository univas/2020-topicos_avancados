package br.edu.univas.si7.lab7.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.edu.univas.si7.lab7.dao.StudentDAO;

@Configuration
@ComponentScan("br.edu.univas.si7.lab7.entities")
public class StudentConfig {

	@Bean
	public StudentDAO studentDAO() { //default beanId: studentDAO (nome do método)
		return new StudentDAO();
	}

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory emFactory = null;

		try {
			// Create the Factory
			emFactory = Persistence.createEntityManagerFactory("student_PU");
		} catch (Throwable e) {
			// Make sure you log the exception , as it might be swallowed
			System.err.println("Error creating EntityManagerFactory ." + e);
			throw new ExceptionInInitializerError(e);
		}
		return emFactory.createEntityManager();
	}
}
