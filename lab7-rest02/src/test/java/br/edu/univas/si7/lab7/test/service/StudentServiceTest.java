package br.edu.univas.si7.lab7.test.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.edu.univas.si7.lab7.dao.StudentDAO;
import br.edu.univas.si7.lab7.entities.Student;
import br.edu.univas.si7.lab7.rest.ResponseStatus;
import br.edu.univas.si7.lab7.rest.support.StudentException;
import br.edu.univas.si7.lab7.service.StudentService;

public class StudentServiceTest {

	@Mock
	private StudentDAO studentDAO;

	@InjectMocks
	private StudentService service;

	// @Mock
	// private EntityManager em = Mockito.mock(EntityManager.class);

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetStudent() {
		Student result = new Student(1, "S1");
		Mockito.when(studentDAO.findById(1)).thenReturn(result);
		Student student = service.getStudent(1);
		assertSame(result, student);

		try {
			student = service.getStudent(2);
			fail("Não pode chegar aqui");
		} catch (StudentException e) {
			// ok
		}
	}

	@Test
	public void testCreateStudent() {

		Student newStudent = new Student(1, "S1");
		service.createStudent(newStudent);
		Mockito.verify(studentDAO).save(newStudent);
		
		Mockito.doThrow(new StudentException()).when(studentDAO).save(newStudent);
		try {
			service.createStudent(newStudent);
			fail("Não pode chegar aqui");
		} catch (StudentException e) {
			// ok
		}
	}

	@Test
	public void testUpdateStudent() {
		Student theStudent = new Student(1, "S1");
		
		Student resultFind = new Student(1, "S1");
		Mockito.when(studentDAO.findById(1)).thenReturn(resultFind);
		
		ResponseStatus result = service.updateStudent(1, theStudent);
		assertSame(ResponseStatus.STATUS.OK.ordinal(), result.getStatus());
		Mockito.verify(studentDAO).update(theStudent);

		//student not found
		Mockito.when(studentDAO.findById(1)).thenReturn(null);
		try {
			result = service.updateStudent(1, theStudent);
		} catch(StudentException e) {
			//ok
		}
	}

	@Test
	public void testRemoveStudent() {
		Student theStudent = new Student(1, "S1");
		
		Student resultFind = new Student(1, "S1");
		Mockito.when(studentDAO.findById(1)).thenReturn(resultFind);
		
		service.removeStudent(1);
		Mockito.verify(studentDAO).remove(resultFind);
		
//		fail("Not yet implemented");
	}

}
