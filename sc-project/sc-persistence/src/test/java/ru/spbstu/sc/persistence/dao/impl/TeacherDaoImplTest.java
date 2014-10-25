package ru.spbstu.sc.persistence.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.persistence.dao.TeacherDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/sc-persistence-context.xml")
public class TeacherDaoImplTest {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Test
	public void testGetTeacherById() {
		Teacher teacher = teacherDao.getTeacherById(3);
		assertNotNull(teacher);
		assertEquals(3, teacher.getId());
		assertEquals("Semen", teacher.getFirstName());
		assertEquals("Semenov", teacher.getLastName());
		assertEquals("Head of department", teacher.getPosition());
	}
	
	@Test
	public void testGetTeachersWithNames() {
		List<Teacher> teachers = teacherDao.getTeachersWithNames();
		assertNotNull(teachers);
		assertEquals(2, teachers.size());
		assertNotEquals(teachers.get(0).getId(), 0);
		assertNotNull(teachers.get(0).getFirstName());
		assertNotNull(teachers.get(0).getLastName());
	}
}