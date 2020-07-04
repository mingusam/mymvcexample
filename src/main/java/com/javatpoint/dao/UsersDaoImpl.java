package com.javatpoint.dao;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.javatpoint.models.Users;

public class UsersDaoImpl implements UsersDao{

	private JdbcTemplate template;
	
	public UsersDaoImpl(DataSource datasource) {
		template = new JdbcTemplate((javax.sql.DataSource) datasource);
	}
	public void save(Users user) {
		String insert = "insert into users(name) values(?)";
		template.update(insert, user.getName());
	}
	
}
