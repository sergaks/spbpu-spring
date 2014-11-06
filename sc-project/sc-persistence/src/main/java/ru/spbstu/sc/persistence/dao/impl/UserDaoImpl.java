package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.model.User;
import ru.spbstu.sc.persistence.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	protected static final String SELECT_USER_BY_ID = 
			"SELECT user_id, username, email, first_name, last_name, patronymic, birth_date, self_information %s" + 
			"FROM users %s" + 
			"WHERE user_id = ?;";

	protected static final String SELECT_USERS_WITH_NAMES = 
			"SELECT user_id, first_name, last_name " + 
			"FROM users %s";

	protected static final String SELECT_USER_BY_NAME =
			"SELECT user_id, username, password, enabled, email, first_name, last_name, patronymic, birth_date, self_information, student_id, teacher_id " + 
			"FROM users " + 
			"LEFT JOIN students ON users.user_id = students.student_id " +
			"LEFT JOIN teachers ON users.user_id = teachers.teacher_id " +
			"WHERE username = ?;";
	
	@Override
	public User getUserByName(String name) {
		User user = getJdbcTemplate().queryForObject(
				String.format(SELECT_USER_BY_NAME), 
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user;
						if(rs.getInt("student_id") != 0) {
							user = new Student();
						} else if(rs.getInt("teacher_id") != 0) {
							user = new Teacher();
						} else {
							throw new SQLException("User object is not of known type");
						}
						user.setId(rs.getInt("user_id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setEnabled(rs.getBoolean("enabled"));
						user.setEmail(rs.getString("email"));
						user.setFirstName(rs.getString("first_name"));
						user.setLastName(rs.getString("last_name"));
						user.setBirthDate(rs.getDate("birth_date"));
						return user;
					}
				},
				name);
		return user;
	}
}

class UserNamesRowMapper<T extends User> implements RowMapper<T> {

	private Class<T> userClass;

	public UserNamesRowMapper(Class<T> userClass) {
		this.userClass = userClass;
	}

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		T user;
		try {
			user = userClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		user.setId(rs.getInt("user_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		return user;
	}

}

class UserRowMapper<T extends User> implements RowMapper<T> {

	private Class<T> userClass;

	public UserRowMapper(Class<T> userClass) {
		this.userClass = userClass;
	}

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		T user;
		try {
			user = userClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}

		user.setId(rs.getInt("user_id"));
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setBirthDate(rs.getDate("birth_date"));

		return user;
	}
}