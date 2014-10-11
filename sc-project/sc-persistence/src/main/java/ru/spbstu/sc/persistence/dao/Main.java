package ru.spbstu.sc.persistence.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.spbstu.sc.model.Student;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring/sc-persistence-context.xml");
		StudentDao studentDao = applicationContext.getBean(StudentDao.class);
		Student student = studentDao.getStudentById(1);
		System.out.println(student);
	}
	
	// TODO: getCitiesByCountry
	// TODO: getSubwayStationsByCity
	// TODO: getAddressByUser
	
	// Middle:
	
	/**
	 * TODO: move creating test data to separe sql file and put it to src/test/resources/db
	 * make sure that database filled with test data before running tests and cleared after
	 */
	
	/** TODO: 
	 * implement any method that returns List of entities with pagination (using MySQL Limit keyword)
	 **/
	
	/** TODO:
	 * create second data source that uses embedded jetty: create some table on it: for instance StudentStatus
	 * create ru.spbstu.sc.persistence.services.UserService with method updateStatus that will update tables in derby and MySQL calling different daos.
	 */
	
	/**
	 * TODO:
	 * add groups and lessons and implementing returning schedule for group), create all required entities
	 */
	
	// HARD
	
	/** TODO: design and implement automatic schedule module 
	 * (на входе аудитории-преподаватели-предметы-время пар-группы, на выходе расписание занятий)		
	**/
}
