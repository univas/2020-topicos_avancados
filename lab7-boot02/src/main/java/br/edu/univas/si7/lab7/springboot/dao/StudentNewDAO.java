package br.edu.univas.si7.lab7.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import br.edu.univas.si7.lab7.springboot.entities.Student;

@Repository
//@Transactional
public interface StudentNewDAO extends JpaRepository<Student, Integer> {

}
