package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int registration;

	private String email;

	private String name;

	// bi-directional many-to-one association to Course
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses;

	// bi-directional many-to-one association to InstructorDetail
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detail_fk")
	private InstructorDetail instructorDetail;

	public Instructor() {
	}

	public Instructor(int registration, String email, String name) {
		super();
		this.registration = registration;
		this.email = email;
		this.name = name;
	}

	public int getRegistration() {
		return this.registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Course addCours(Course course) {
		getCourses().add(course);
		course.setInstructor(this);

		return course;
	}

	public Course removeCours(Course course) {
		getCourses().remove(course);
		course.setInstructor(null);

		return course;
	}

	public InstructorDetail getInstructorDetail() {
		return this.instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

}