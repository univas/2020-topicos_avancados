package br.edu.univas.si7.lab7;


import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.CourseConfig;
import br.edu.univas.si7.lab7.entities.Instructor;
import br.edu.univas.si7.lab7.entities.InstructorDetail;

public class AppOneToOne01 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CourseConfig.class);
		
		EntityManager em = context.getBean("entityManager", EntityManager.class);
		
		//TODO: salvar um instructor e seus detalhes (verificar o comportamento do cascade)
		//Criar um objeto Instructor
		Instructor inst01 = new Instructor(1, "instrutor01@gmail.com", "Instrutor 01");
		em.getTransaction().begin();
		em.persist(inst01);
		em.getTransaction().commit();
		
		Instructor inst02 = new Instructor(2, "instrutor02@gmail.com", "Instrutor 02");
		InstructorDetail detail02 = new InstructorDetail("linkedin 02", "skype 02");
		inst02.setInstructorDetail(detail02);
		
		em.getTransaction().begin();
		em.persist(inst02);
		em.getTransaction().commit();
		
		context.close();
	}
}