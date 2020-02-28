package br.edu.univas.si7.lab7.model;

public class GraduationStudentBean implements StudentInterface {

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
