package br.edu.univas.si7.lab7.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.univas.si7.lab7.entities.Student;

@WebServlet("/StudentService")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//TODO: implementar
		System.out.println("Chamou doGet de StudentService");
		
		//criar uma lista fixa de objetos Student
		Student st1 = new Student(1, "João");
		Student st2 = new Student(2, "Joaquim");
		Student st3 = new Student(3, "Júlia");
		
		List<Student> lista = new ArrayList<Student>();
		lista.add(st1);
		lista.add(st2);
		lista.add(st3);
		
		//setar a lista como atributo do request
		req.setAttribute("studentList", lista);
		
		//criar uma página para mostrar a lista de objetos
		
		//fazer o dispatch.forward(...) para uma página para mostrar a lista de objetos
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/StudentList.jsp");
		disp.forward(req, resp);
	}
}
