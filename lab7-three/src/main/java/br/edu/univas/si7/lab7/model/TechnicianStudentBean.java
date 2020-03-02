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
		return "Welcome to technician course!";
	}

	public String getHintOfTheDay() {
		return hintService.getHint();
	}

	public String getSite() {
		System.out.println("Inside getSite of TechnicianStudentBean.");
		return site;
	}

	public void setSite(String site) {
		System.out.println("Inside setSite of TechnicianStudentBean.");
		this.site = site;
	}

	public String getInstitution() {
		System.out.println("Inside getInstitution of TechnicianStudentBean.");
		return institution;
	}

	public void setInstitution(String institution) {
		System.out.println("Inside setInstitution of TechnicianStudentBean.");
		this.institution = institution;
	}
}
