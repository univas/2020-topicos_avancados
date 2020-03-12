package br.edu.univas.si7.lab7;


import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.CourseConfig;

public class AppOneToOne01 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CourseConfig.class);
		
		EntityManager em = context.getBean("entityManager", EntityManager.class);
		
		//TODO: salvar um instructor e seus detalhes (verificar o comportamento do cascade)
		
		
		context.close();
	}
}