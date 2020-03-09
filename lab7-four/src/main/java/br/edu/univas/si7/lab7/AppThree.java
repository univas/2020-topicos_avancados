package br.edu.univas.si7.lab7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentConfiguration;
import br.edu.univas.si7.lab7.model.PostGradStudentBean;

public class AppThree {

	public static void main(String[] args) {
		
		//create context
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		//load bean
		PostGradStudentBean studentOne = 
				context.getBean("postStudentBean", PostGradStudentBean.class);

		PostGradStudentBean studentTwo = 
				context.getBean("postStudentBean", PostGradStudentBean.class);

		// confirm that the objects are different
		
		//true -> singleton
		//false -> prototype
		boolean sameOject = studentOne == studentTwo;
		System.out.println("Same object: " + sameOject);
		
		//close context
		context.close();
	}
}