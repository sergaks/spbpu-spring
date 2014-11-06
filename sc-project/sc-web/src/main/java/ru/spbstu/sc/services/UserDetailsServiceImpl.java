package ru.spbstu.sc.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ru.spbstu.sc.model.Student;
import ru.spbstu.sc.model.Teacher;
import ru.spbstu.sc.model.User;
import ru.spbstu.sc.persistence.dao.UserDao;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByName(username);
		if(user == null) {
			new UsernameNotFoundException(String.format("Username %s not found", username));
		}
		String authority;
		if(user instanceof Student) {
			authority = "STUDENT";
		} else if (user instanceof Teacher) {
			authority = "TEACHER";
		} else {
			throw new UsernameNotFoundException(String.format("User %s doesn't have authorities", username));
		}
		
		return new UserDetailsImpl(user,Collections.singleton(new SimpleGrantedAuthority(authority)));
	}
}
