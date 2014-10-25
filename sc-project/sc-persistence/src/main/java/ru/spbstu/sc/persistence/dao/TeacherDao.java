package ru.spbstu.sc.persistence.dao;

import java.util.List;

import ru.spbstu.sc.model.Teacher;

public interface TeacherDao {

	Teacher getTeacherById(int id)	;
	
	List<Teacher> getTeachersWithNames();
	
}
