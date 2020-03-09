package br.edu.univas.si7.lab7;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentConfig;
import br.edu.univas.si7.lab7.dao.StudentDAO;
import br.edu.univas.si7.lab7.entities.Student;

public class AppTwo {

	public static void main(String[] args) {
		
		//create context
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfig.class);
		
		//load bean
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);
		
		//use bean
		List<Student> lista = dao.listAll();
		System.out.println(lista);
		
		//close context
		context.close();
	}
}