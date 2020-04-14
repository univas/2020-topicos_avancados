package br.edu.univas.si7.lab7.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentAppConfig;
import br.edu.univas.si7.lab7.dao.StudentDAO;
import br.edu.univas.si7.lab7.entities.Student;

@WebServlet("/studentService")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentAppConfig.class);

		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);
		List<Student> list = dao.listAll();
		System.out.println("Students: " + list);

		req.setAttribute("studentList", list);
		req.setAttribute("agora", new Date());
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/students.jsp");
		disp.forward(req, resp);
		
//		resp.getWriter().append("Students: </br>");
//		for (Student student : list) {
//			resp.getWriter().append("" + student + " </br>");
//		}
		context.close();
	}
}
