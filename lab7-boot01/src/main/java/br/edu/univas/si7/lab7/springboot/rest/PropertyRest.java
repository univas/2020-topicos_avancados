package br.edu.univas.si7.lab7.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyRest {

	@Value("${course.name}")
	private String courceName;

	@Value("${institution.name}")
	private String institution;

	@Value("${institution.website}")
	private String site;

	@GetMapping("/course")
	public String getCourseData() {
		return "Course name: " + courceName + " Institution: " + institution + " site: " + site;
	}
}
