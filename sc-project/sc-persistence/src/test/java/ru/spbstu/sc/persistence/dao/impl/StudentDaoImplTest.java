package ru.spbstu.sc.persistence.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.persistence.dao.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/sc-persistence-context.xml")
public class StudentDaoImplTest {
	
	@Autowired
	private StudentDao studentDao;
	
	@Test
	public void testGetStudentById() {
		Student student = studentDao.getStudentById(1);
		assertNotNull(student);
		assertEquals(1, student.getId());
		assertEquals("Ivan", student.getFirstName());
		assertEquals(2014, student.getStartYear());
		assertEquals(2019, student.getGraduationYear());

	}
	
	@Test
	public void testGetStudentsWithNames() {
		List<Student> students = studentDao.getStudentsWithNames();
		assertNotNull(students);
		assertEquals(2, students.size());
		assertNotEquals(students.get(0).getId(), 0);
		assertNotNull(students.get(0).getFirstName());
		assertNotNull(students.get(0).getLastName());
	}
}