package br.edu.univas.si7.lab7.springboot.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

	@GetMapping("/")
	public String hiMessage() {
		return "Hi from springboot app: " + new Date();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from springboot app: " + new Date();
	}
}
