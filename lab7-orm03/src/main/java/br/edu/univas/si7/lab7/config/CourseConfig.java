package br.edu.univas.si7.lab7.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.edu.univas.si7.lab7.dao.InstructorDAO;
import br.edu.univas.si7.lab7.entities.Instructor;
import br.edu.univas.si7.lab7.services.InstructorService;

@Configuration
@ComponentScan("br.edu.univas.si7.lab7.entities")
@ComponentScan("br.edu.univas.si7.lab7.services")
public class CourseConfig {

	@Bean
	public InstructorService instructorService() {
		return new InstructorService();
	}

	@Bean
	public InstructorDAO instructorDAO() {
		return new InstructorDAO();
	}

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory emFactory = null;

		try {
			// Create the Factory
			emFactory = Persistence.createEntityManagerFactory("course_PU");
		} catch (Throwable e) {
			// Make sure you log the exception , as it might be swallowed
			System.err.println("Error creating EntityManagerFactory ." + e);
			throw new ExceptionInInitializerError(e);
		}
		return emFactory.createEntityManager();
	}
}
