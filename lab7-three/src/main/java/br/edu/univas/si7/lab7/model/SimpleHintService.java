package br.edu.univas.si7.lab7.model;

import org.springframework.stereotype.Component;

@Component
public class SimpleHintService implements HintService {

	public String getHint() {
		return "Study hard!!!";
	}
}
