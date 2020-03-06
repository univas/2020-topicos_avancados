package br.edu.univas.si7.lab7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentConfiguration;
import br.edu.univas.si7.lab7.model.GraduationStudentBean;

public class AppOne {

	public static void main(String[] args) {
		
		//create context
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		//load bean
		GraduationStudentBean studentOne = 
				context.getBean("graduationStudentBean", GraduationStudentBean.class);
		
		//use bean
		System.out.println(studentOne.getWelcomeMessage());
		System.out.println(studentOne.getHintOfTheDay());
		
		//close context
		context.close();
	}
}