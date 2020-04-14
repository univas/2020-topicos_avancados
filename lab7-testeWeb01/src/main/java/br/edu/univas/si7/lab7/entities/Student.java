package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REGISTRATION")
	private int registration;

	private String name;

	public Student() {

	}

	public Student(int registration, String name) {
		super();
		this.registration = registration;
		this.name = name;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [registration=" + registration + ", name=" + name + "]";
	}

}
