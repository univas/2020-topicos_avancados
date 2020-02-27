package br.edu.univas.si7.lab7.model;

public class GraduationStudentBean implements StudentInterface {

	private HintService hintService;

	public String getWelcomeMessage() {
		return "Welcome to graduation cource!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

	//setHintService missing
}
