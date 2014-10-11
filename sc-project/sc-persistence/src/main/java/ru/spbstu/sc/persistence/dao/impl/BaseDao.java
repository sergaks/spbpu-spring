package ru.spbstu.sc.persistence.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {

    private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
