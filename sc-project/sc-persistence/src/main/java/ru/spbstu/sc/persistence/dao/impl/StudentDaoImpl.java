package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

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

	@Override
	public Student getStudentById(int id) {
		Student student = getJdbcTemplate().queryForObject(SELECT_STUDENT_BY_ID, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Student student = new Student();
            	student.setId(rs.getInt("user_id"));
            	student.setUserName(rs.getString("user_name"));
            	student.setEmail(rs.getString("email"));
            	student.setFirstName(rs.getString("first_name"));
            	student.setLastName(rs.getString("last_name"));
            	student.setStartYear(rs.getShort("start_year"));
            	student.setGraduationYear(rs.getShort("graduation_year"));
                return student;
            }
        }, id);
		return student;
	}

}
