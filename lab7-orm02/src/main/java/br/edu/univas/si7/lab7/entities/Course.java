package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code;

	private String title;

	// bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name = "instructor_reg_fk")
	private Instructor instructor;

	// bi-directional many-to-many association to Student
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	// bi-directional many-to-one association to Review
	@OneToMany(mappedBy = "course")
	private List<Review> reviews;

	public Course() {
	}

	public Course(String code, String title, Instructor instructor) {
		super();
		this.code = code;
		this.title = title;
		this.instructor = instructor;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setCourse(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setCourse(null);

		return review;
	}

}