package ru.spbstu.sc.persistence.dao.impl;

import static org.junit.Assert.*;

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
	}
}