package br.edu.univas.si7.lab7.model;

public class PostGradStudentBean implements StudentInterface {

	private HintService hintService;

	public PostGradStudentBean(HintService theHintService) {
		this.hintService = theHintService;
		System.out.println("PostGradStudentBean constructor.");
	}

	public void doStartUp() {
		System.out.println("doStartUp inside PostGradStudentBean.");
	}

	public void doCleanUp() {
		System.out.println("doCleanUp inside PostGradStudentBean.");
	}

	public String getWelcomeMessage() {
		return "Welcome to post graduate cource!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

}
