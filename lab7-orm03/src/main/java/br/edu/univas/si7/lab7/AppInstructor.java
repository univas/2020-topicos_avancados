package br.edu.univas.si7.lab7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.CourseConfig;
import br.edu.univas.si7.lab7.entities.Instructor;
import br.edu.univas.si7.lab7.services.InstructorService;

public class AppInstructor {

	public static void main(String[] args) {

		// create context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CourseConfig.class);

		// load bean
		InstructorService service = context.getBean("instructorService", InstructorService.class);

		// use bean
		Instructor inst = new Instructor(2, "jonas@univas.edu.br", "Jonas");
		service.saveInstructor(inst);

		// close context
		context.close();
	}
}