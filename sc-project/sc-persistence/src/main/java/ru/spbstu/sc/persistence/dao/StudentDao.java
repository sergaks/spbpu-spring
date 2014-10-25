package ru.spbstu.sc.persistence.dao;

import java.util.List;

import ru.spbstu.sc.model.Student;

public interface StudentDao {

	Student getStudentById(int id);
	
	List<Student> getStudentsWithNames();
		
}
