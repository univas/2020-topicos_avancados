package br.edu.univas.si7.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.lab7.dao.IGenericDao;
import br.edu.univas.si7.lab7.entities.Instructor;

@Service
class InstructorService implements IFooService{
 
   IGenericDao<Instructor> dao;
 
   @Autowired
   public void setDao(IGenericDao<Instructor> daoToSet) {
      dao = daoToSet;
      dao.setClazz(Instructor.class);
   }
 
   // ...
}
