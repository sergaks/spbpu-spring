package ru.spbstu.sc.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.persistence.dao.TeacherDao;

@RestController
@RequestMapping("/rest/teachers")
public class TeacherController {

	@Autowired
	private TeacherDao teacherDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Teacher> getTeachers() {
		return teacherDao.getTeachersWithNames();
	}
	
	@RequestMapping(value="/{teacherId}", method = RequestMethod.GET)
	public Teacher getTeacher(@PathVariable int teacherId) {
		return teacherDao.getTeacherById(teacherId);
	}
}
