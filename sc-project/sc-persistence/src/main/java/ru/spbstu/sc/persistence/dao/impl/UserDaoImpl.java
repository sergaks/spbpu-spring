package ru.spbstu.sc.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.spbstu.sc.model.User;

public class UserDaoImpl extends BaseDao {

	protected static final String SELECT_USER_BY_ID = "SELECT user_id, user_name, email, first_name, last_name, patronymic, birth_date, self_information %s" + 
			"FROM users %s" + 
			"WHERE user_id = ?;";

	protected static final String SELECT_USERS_WITH_NAMES = 
			"SELECT user_id, first_name, last_name " + 
			"FROM users %s";
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
		user.setUserName(rs.getString("user_name"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setBirthDate(rs.getDate("birth_date"));

		return user;
	}
}