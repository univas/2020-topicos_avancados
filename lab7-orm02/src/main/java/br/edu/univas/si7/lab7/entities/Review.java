package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_id")
	private int autoId;

	private String comment;

	// bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name = "course_code_fk")
	private Course course;

	public Review() {
	}

	public Review(String comment, Course course) {
		super();
		this.comment = comment;
		this.course = course;
	}

	public int getAutoId() {
		return this.autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}