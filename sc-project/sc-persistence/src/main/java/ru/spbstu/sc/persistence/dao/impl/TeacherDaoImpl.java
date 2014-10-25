package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.persistence.dao.TeacherDao;

@Repository
public class TeacherDaoImpl extends UserDaoImpl implements TeacherDao {

	@Override
	public Teacher getTeacherById(int id) {
		Teacher teacher = getJdbcTemplate().queryForObject(
				String.format(SELECT_USER_BY_ID, " ,position ", 
						" LEFT JOIN teachers ON users.user_id = teachers.teacher_id "), 
				new TeacherRowMapper(),
				id);
		return teacher;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Teacher> getTeachersWithNames() {
		return getJdbcTemplate().query(
				String.format(SELECT_USERS_WITH_NAMES, " INNER JOIN teachers ON users.user_id = teachers.teacher_id"), 
				new UserNamesRowMapper(Teacher.class)
		);
	}

}

class TeacherRowMapper extends UserRowMapper<Teacher> {
	
	public TeacherRowMapper() {
		super(Teacher.class);
	}

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher = super.mapRow(rs, rowNum);
		teacher.setPosition(rs.getString("position"));
		return teacher;
	}
}
