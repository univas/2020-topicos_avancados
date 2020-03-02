package br.edu.univas.si7.lab7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.edu.univas.si7.lab7.model.GraduationStudentBean;

public class AppOne {

	public static void main(String[] args) {
		
		//create context
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
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