package br.edu.univas.si7.lab7.service;

import java.io.IOException;
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
	
	//apenas como exemplo didático
	private AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(StudentConfig.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Chamou doGet de StudentService");
		
		//ajuste para editar um student
		String type = req.getParameter("type");//controla o fluxo de edição/novo
		if("edit".equals(type)) {
			processEdit(req, resp);
			return;
		}
		
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
		
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);
		
		List<Student> studentList = dao.listAll();

//		//criar uma lista fixa de objetos Student
//		List<Student> studentList = new ArrayList<Student>();
//		studentList.add(new Student(1, "João"));
//		studentList.add(new Student(2, "Joaquim"));
//		studentList.add(new Student(3, "Júlia"));
		
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
		String type = req.getParameter("type");//controla o fluxo de editar/novo
		
		int register = Integer.parseInt(registerStr); //converte de String para int
		
		Student student = new Student(register, name);
		
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);

		if("update".equals(type)) {
			dao.update(student);
		} else {
			dao.save(student);
		}
		//direciona para a tela de listagem de students
		this.doGet(req, resp);
	}
	
	//TODO: Exercício: implementar uma edição de Student.
	
	protected void processEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String registerStr = req.getParameter("register");
		int register = Integer.parseInt(registerStr); //converte de String para int
		
		StudentDAO dao = context.getBean("studentDAO", StudentDAO.class);

		Student student = dao.findById(register);
		if(student == null) { //se não achou criar um novo para aparecer vazio na tela
			student = new Student();
		}
		
		 //ajustei o arquivo NewStudent.jsp para receber as informações do objeto studentToEdit
		req.setAttribute("studentToEdit", student);
		//usado para controlar o fluxo no doGet e doPost devido ao edit/update
		req.setAttribute("actionType", "update");
		
		//abre a tela NewStudent.jsp
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/NewStudent.jsp");
		disp.forward(req, resp);
	}
}
