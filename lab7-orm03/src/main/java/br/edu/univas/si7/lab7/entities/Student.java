package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registration;

	private String name;

	// bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(name = "enrollment", 
	joinColumns = { 
			@JoinColumn(name = "student_registry") }, 
			inverseJoinColumns = { @JoinColumn(name = "course_code") })
	private List<Course> courses;

	public Student() {
	}

	public Student(int registration, String name) {
		super();
		this.registration = registration;
		this.name = name;
	}

	public int getRegistration() {
		return this.registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}