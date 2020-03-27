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

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.edu.univas.si7.lab7.config.StudentConfig;
import br.edu.univas.si7.lab7.dao.StudentDAO;
import br.edu.univas.si7.lab7.entities.Student;

@WebServlet("/StudentService")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Chamou doGet de StudentService");
		
		//TODO: Exercício: trazer a lista de Students do banco de dados
		//1 - copiar as classes do projeto lab7-orm01: StudentConfig, StudentDAO e Student (entity)
		//2 - injetar o DAO no sevlet para fazer a consulta dos Students.
		//3 - Substituir a lista fixa pelo novo código.
		//4 - Executar o projeto no Tomcat e testar o GET no servlet.
		//
		//Observação 1: Trazer a pasta META-INF também (por causa do persistence.xml).
		//Observação 2: Criar a tabela STUDENT se ela ainda não existir.
		//Observação 3: Atualizar o pom.xml
		//Observação 4: Ajustar as configurações de conexão com o banco de dados, se necessário.
		
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfig.class);
		
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);
		
		List<Student> studentList = dao.listAll();

		context.close();

//		//criar uma lista fixa de objetos Student
//		Student st1 = new Student(1, "João");
//		Student st2 = new Student(2, "Joaquim");
//		Student st3 = new Student(3, "Júlia");
//		
//		List<Student> studentList = new ArrayList<Student>();
//		lista.add(st1);
//		lista.add(st2);
//		lista.add(st3);
		
		//setar a lista como atributo do request
		req.setAttribute("studentList", studentList);
		
		//criar uma página para mostrar a lista de objetos
		//fazer o dispatch.forward(...) para uma página para mostrar a lista de objetos
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/StudentList.jsp");
		disp.forward(req, resp);
	}
	
	//TODO: implementar para salvar um novo student
	//criar um formulário (arquivo jsp) para cadastrar um aluno
	//implementar o método doPost para salvar o aluno no banco de dados
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String registerStr = req.getParameter("register");
		String name = req.getParameter("name");
		
		int register = Integer.parseInt(registerStr); //converte de String para int
		
		Student student = new Student(register, name);
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfig.class);
		
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);

		dao.save(student);
		
		context.close();
		
		//direciona para a tela de listagem de students
		this.doGet(req, resp);
	}
	
	//TODO: Exercício: implementar uma edição de Student.
	
	
}
