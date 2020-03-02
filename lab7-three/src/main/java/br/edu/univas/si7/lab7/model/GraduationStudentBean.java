package br.edu.univas.si7.lab7.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//bean id default = graduationStudentBean
public class GraduationStudentBean implements StudentInterface {

	@Autowired //injeta um objeto de uma classe que implementa HintService
	private HintService hintService;
	
	public GraduationStudentBean() {
		System.out.println("Default constructor of GraduationStudentBean.");
	}

	public String getWelcomeMessage() {
		return "Welcome to graduation course!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

	//TODO: setHintService missing
	public void setHintService(HintService hintService) {
		this.hintService = hintService;
	}
}
