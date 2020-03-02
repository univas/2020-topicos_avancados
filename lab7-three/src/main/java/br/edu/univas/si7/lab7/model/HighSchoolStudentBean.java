package br.edu.univas.si7.lab7.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") //default
@Scope("prototype")
public class HighSchoolStudentBean implements StudentInterface {

	private HintService hintService;

	public String getWelcomeMessage() {
		return "Welcome to technician course!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

}
