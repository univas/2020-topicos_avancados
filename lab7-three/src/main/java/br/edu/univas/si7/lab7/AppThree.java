package br.edu.univas.si7.lab7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.edu.univas.si7.lab7.model.HighSchoolStudentBean;

public class AppThree {

	public static void main(String[] args) {
		
		//create context
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//load bean
		HighSchoolStudentBean studentOne = 
				context.getBean("highSchoolStudentBean", HighSchoolStudentBean.class);

		HighSchoolStudentBean studentTwo = 
				context.getBean("highSchoolStudentBean", HighSchoolStudentBean.class);
		
		//use bean
		boolean sameObject = studentOne == studentTwo;
		
		System.out.println("Same object: " + sameObject);
		
		//close context
		context.close();
	}
}