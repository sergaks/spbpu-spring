package ru.spbstu.sc.persistence.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.model.User;
import ru.spbstu.sc.persistence.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/sc-persistence-context.xml")
public class UserDaoImplTest {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Test
	public void testGetUserByName() {
		User user = userDao.getUserByName("ivan_ivanov");
		assertNotNull(user);
		assertEquals(1, user.getId());
		assertEquals("Ivan", user.getFirstName());
		assertTrue(user instanceof Student);
		User user2 = userDao.getUserByName("semen_semenov");
		assertNotNull(user2);
		assertEquals(3, user2.getId());
		assertEquals("Semen", user2.getFirstName());
		assertTrue(user2 instanceof Teacher);
	}
	
}