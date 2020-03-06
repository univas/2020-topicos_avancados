package br.edu.univas.si7.lab7.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PostGradStudentBean implements StudentInterface {

	private HintService hintService;

	public PostGradStudentBean(HintService theHintService) {
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
