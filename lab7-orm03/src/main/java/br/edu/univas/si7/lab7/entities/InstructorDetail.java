package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
@NamedQuery(name = "InstructorDetail.findAll", query = "SELECT i FROM InstructorDetail i")
public class InstructorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_id")
	private int autoId;

	private String linkedin;

	private String skype;
	
	@OneToOne(mappedBy="instructorDetail", //nome do atributo da classe InstructorDetail na classe Instructor
				cascade=CascadeType.ALL) 
	private Instructor instructor;

	public InstructorDetail() {
	}

	public InstructorDetail(String linkedin, String skype) {
		super();
		this.linkedin = linkedin;
		this.skype = skype;
	}

	public int getAutoId() {
		return this.autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getLinkedin() {
		return this.linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

}