package br.edu.univas.si7.lab7;


import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.CourseConfig;

public class AppOneToOne04 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CourseConfig.class);
		
		EntityManager em = context.getBean("entityManager", EntityManager.class);
		
		//TODO: deletar um objeto de detalhes (o cascade faz apagar o instructor também)
		
		
		context.close();
	}
}