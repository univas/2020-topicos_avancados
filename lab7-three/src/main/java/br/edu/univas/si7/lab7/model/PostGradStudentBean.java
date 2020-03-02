package br.edu.univas.si7.lab7.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("postStudentBean")
public class PostGradStudentBean implements StudentInterface {

	private HintService hintService;

	
	@Autowired //indica que será injetado um objeto no construtor
	public PostGradStudentBean(
			//anotação do parâmetro
			@Qualifier("simpleHintService") //indica o beanId a ser injetado 
			HintService theHintService) {
		this.hintService = theHintService;
		System.out.println("PostGradStudentBean constructor.");
	}

	@PostConstruct
	public void doStartUp() {
		System.out.println("doStartUp inside PostGradStudentBean.");
	}

	@PreDestroy
	public void doCleanUp() {
		System.out.println("doCleanUp inside PostGradStudentBean.");
	}

	public String getWelcomeMessage() {
		return "Welcome to post graduate course!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

}
