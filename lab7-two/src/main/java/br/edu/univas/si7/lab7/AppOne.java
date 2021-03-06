package br.edu.univas.si7.lab7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.edu.univas.si7.lab7.model.GraduationStudentBean;

public class AppOne {

	public static void main(String[] args) {
		
		//create context
		System.out.println("create context");
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//load bean
		System.out.println("load bean");
		GraduationStudentBean studentOne = 
				context.getBean("graduationBean", GraduationStudentBean.class);
		
		//use bean
		System.out.println("use bean");
		System.out.println(studentOne.getWelcomeMessage());
		System.out.println(studentOne.getHintOfTheDay());
		
		//close context
		System.out.println("close context");
		context.close();
	}
}