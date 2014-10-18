package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.persistence.dao.StudentDao;

@Repository
public class StudentDaoImpl extends BaseDao implements StudentDao {

	private static final String SELECT_STUDENT_BY_ID = 
			  "SELECT user_id, user_name, email, first_name, last_name, patronymic, birth_date, self_information, address_id, start_year, graduation_year "
			+ "FROM students "
			+ "LEFT JOIN users ON students.student_id = users.user_id "
			+ "WHERE student_id = ?;";

	private static final String SELECT_STUDENT_WITH_NAMES = 
			  "SELECT user_id, first_name, last_name "
			+ "FROM users "
			+ "INNER JOIN students ON users.user_id = students.student_id";

	@Override
	public Student getStudentById(int id) {
		Student student = getJdbcTemplate().queryForObject(
				SELECT_STUDENT_BY_ID, 
				new StudentRowMapper(),
				id);
		return student;
	}

	@Override
	public List<Student> getStudentsWithNames() {
		return getJdbcTemplate().query(
				SELECT_STUDENT_WITH_NAMES, 
				new RowMapper<Student>() {
					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						student.setId(rs.getInt("user_id"));
						student.setFirstName(rs.getString("first_name"));
						student.setLastName(rs.getString("last_name"));
						return student;
					}
		});
	}
	
	
}

class StudentRowMapper implements RowMapper<Student> {
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("user_id"));
		student.setUserName(rs.getString("user_name"));
		student.setEmail(rs.getString("email"));
		student.setFirstName(rs.getString("first_name"));
		student.setLastName(rs.getString("last_name"));
		student.setBirthDate(rs.getDate("birth_date"));
		student.setStartYear(rs.getShort("start_year"));
		student.setGraduationYear(rs
				.getShort("graduation_year"));
		return student;
	}
}
