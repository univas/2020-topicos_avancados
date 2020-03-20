package br.edu.univas.si7.lab7.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//exemplo de URL que cai nesse método:
		//http://localhost:8080/lab7-web01/HelloService?nome=Roberto
		
		//pegando o parâmetro vindo na URL
		//se não existir o parâmetro, o valor retornado será null
		String name = request.getParameter("nome");
		
		//escrevendo uma resposta para ser enviada de volta para o browser
		response.getWriter().append("Hello " + name + ": agora é: " + new Date());
	}
	
	//Exercício:
	//Implementar o método doPost para tratar requisições POST.
	//Criar um arquivo html com um formulário simples (1 campo e um botão) para fazer o POST.
	//Esse método deve retornar uma mensagem de acordo com o campo do formulário.

}
