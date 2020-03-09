package br.edu.univas.si7.lab7.model;

public class HighSchoolStudentBean implements StudentInterface {

	private HintService hintService;

	public String getWelcomeMessage() {
		return "Welcome to technician course!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

}
