package br.edu.univas.si7.lab7.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRest {

	@GetMapping("/hello") // endpoint
	public String sayHello() {
		return "Hello!";
	}

}
