package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.persistence.dao.StudentDao;

@Repository
public class StudentDaoImpl extends UserDaoImpl implements StudentDao {

	@Override
	public Student getStudentById(int id) {
		Student student = getJdbcTemplate().queryForObject(
				String.format(SELECT_USER_BY_ID, " ,start_year, graduation_year ",
						" LEFT JOIN students ON users.user_id = students.student_id "), 
				new StudentRowMapper(),
				id);
		return student;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Student> getStudentsWithNames() {
		return getJdbcTemplate().query(
				String.format(SELECT_USERS_WITH_NAMES, " INNER JOIN students ON users.user_id = students.student_id"), 
				new UserNamesRowMapper(Student.class)
		);
	}
	
}

class StudentRowMapper extends UserRowMapper<Student> {
	
	public StudentRowMapper() {
		super(Student.class);
	}

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = super.mapRow(rs, rowNum);
		student.setStartYear(rs.getShort("start_year"));
		student.setGraduationYear(rs.getShort("graduation_year"));
		return student;
	}
}
