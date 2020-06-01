package br.edu.univas.si7.lab7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 7876988844153860663L;

	@Id
	@Column(name="REGISTRATION")
	private int register;
	
	private String name;
	
	public Student() {
	}

	public Student(int register, String name) {
		super();
		this.register = register;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [register=" + register + ", name=" + name + "]";
	}

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + register;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (register != other.register)
			return false;
		return true;
	}
}
