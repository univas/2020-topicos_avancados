package br.edu.univas.si7.lab7;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.CourseConfig;
import br.edu.univas.si7.lab7.dao.AbstractDAO;
import br.edu.univas.si7.lab7.dao.InstructorDAO;
import br.edu.univas.si7.lab7.entities.Course;
import br.edu.univas.si7.lab7.entities.Instructor;
import br.edu.univas.si7.lab7.entities.Student;

public class AppTestAbstractDAO {

	public static void main(String[] args) {

		Instructor inst = new Instructor(1, "a@b.c", "Name 01");
		Student student = new Student(1, "Student 01");

		ArrayList<Instructor> lista = new ArrayList<Instructor>();
		lista.add(inst);

		// AbstractDAO<Instructor> dao1 = new AbstractDAO<Instructor>();
		// dao1.setClazz(Instructor.class);
		// dao1.save(inst);
		// dao1.update(inst);//demonstração didática
		// dao1.delete(inst);//demonstração didática
		// Instructor result = dao1.findOne(1L);
		//
		// AbstractDAO<Student> dao2 = new AbstractDAO<Student>();
		// dao2.save(student);

		InstructorDAO dao3 = new InstructorDAO();
		dao3.save(inst);
		List<Instructor> lista2 = dao3.findAll();

		System.out.println(lista);

		// Course.class
	}

}