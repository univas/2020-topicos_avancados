package br.edu.univas.si7.lab7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.edu.univas.si7.lab7.model.TechnicianStudentBean;

public class AppThree {

	public static void main(String[] args) {
		
		//create context
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//load bean
		TechnicianStudentBean studentOne = 
				context.getBean("technicianStudentBean", TechnicianStudentBean.class);
		
		//use bean
		System.out.println(studentOne.getWelcomeMessage());
		System.out.println(studentOne.getHintOfTheDay());
		
		System.out.println(studentOne.getSite());
		System.out.println(studentOne.getInstitution());
		
		//close context
		context.close();
	}
}