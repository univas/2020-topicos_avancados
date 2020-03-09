package br.edu.univas.si7.lab7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentConfiguration;
import br.edu.univas.si7.lab7.model.TechnicianStudentBean;

public class AppTwo {

	public static void main(String[] args) {
		
		//create context
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		//load bean
		TechnicianStudentBean studentOne = 
				context.getBean("techStudentBean", TechnicianStudentBean.class);
		
		//use bean
		System.out.println(studentOne.getWelcomeMessage());
		System.out.println(studentOne.getHintOfTheDay());
		
		System.out.println("Site: " + studentOne.getSite());
		System.out.println("Institution: " + studentOne.getInstitution());
		
		//close context
		context.close();
	}
}