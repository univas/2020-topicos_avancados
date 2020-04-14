package br.edu.univas.si7.lab7.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.univas.si7.lab7.entities.Student;

public class Runner {

	public static void main(String[] args) {

		Student student = new Student(1, "Roberto");

		ObjectMapper om = new ObjectMapper();
		try {
			// converte de objeto para string JSON
			String studentJSON = om.writeValueAsString(student);
			System.out.println("Student as JSON String: " + studentJSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String jsonText = "{\"register\":2,\"name\":\"Ricardo\"}";
		try {
			// converte de string JSON para objeto
			Student studentReceived = om.readValue(jsonText, Student.class);
			System.out.println("Student received: " + studentReceived);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
