package ru.spbstu.sc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.persistence.dao.StudentDao;
import ru.spbstu.sc.web.SCWebConstants;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getStudents(Model model) {
		model.addAttribute("students", studentDao.getStudentsWithNames());
		return SCWebConstants.STUDENT_LIST;
	}
	
	@RequestMapping(value="/{studentId}", method = RequestMethod.GET)
	public String getStudent(@PathVariable int studentId, Model model) {
		Student student = studentDao.getStudentById(studentId);
		model.addAttribute("student", student);
		return SCWebConstants.STUDENT_PROFILE;
	}
	
}
