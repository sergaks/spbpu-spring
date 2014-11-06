package ru.spbstu.sc.persistence.dao;

import ru.spbstu.sc.model.User;

public interface UserDao {

	User getUserByName(String name);
	
	// TODO: get all users 
	
	// TODO: get all users with Addresses (all address hierarchy should be filled)
}
