package br.edu.univas.si7.lab7.model;

import java.util.Random;

public class RamdomHintService implements HintService {

	String [] hints = new String [] {
			"Don't collect doubts...",
			"Practice the activities.",
			"Ask to your professor."
	};
	
	private Random rand = new Random();
	
	public String getHint() {
		return hints[rand.nextInt(3)];
	}
}
