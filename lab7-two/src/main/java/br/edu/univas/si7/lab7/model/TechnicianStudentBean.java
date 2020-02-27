package br.edu.univas.si7.lab7.model;

public class TechnicianStudentBean implements StudentInterface {

	private HintService hintService;

	private String site;
	private String institution;

	public TechnicianStudentBean(HintService theHintService) {
		this.hintService = theHintService;
		System.out.println("TechnicianStudentBean constructor.");
	}

	public String getWelcomeMessage() {
		return "Welcome to technician cource!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
