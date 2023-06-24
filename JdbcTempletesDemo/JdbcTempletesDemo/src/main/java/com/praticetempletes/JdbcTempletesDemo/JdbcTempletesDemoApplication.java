package com.praticetempletes.JdbcTempletesDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.praticetempletes.JdbcTempletesDemo.entity.Course;
import com.praticetempletes.JdbcTempletesDemo.entity.CourseJdbcDAO;

@SpringBootApplication
public class JdbcTempletesDemoApplication {


	private static CourseJdbcDAO dao;


	public JdbcTempletesDemoApplication(CourseJdbcDAO dao) {
		this.dao=dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcTempletesDemoApplication.class, args);

		System.out.println("------------------------GET ALL COURSES-------------------");

		System.out.println(dao.getcourselist());
		
		System.out.println("----------------------GET PARTICULAR COURSE----------------");
		System.out.println(dao.getCourse(123));

//		System.out.println("------------------------CREATE COURSE-----------------------");
//		
//		Course c = new Course(55,"englishhh","spokenhh","normal***lihnk");
//		dao.create(c);
		
//		System.out.println("------------------------UPDATE COURSE-----------------------");
//		Course c1 = new Course(22,"teluguuu","spokenuu","normal lihnk");
//		dao.update(c1, 22);
		
		System.out.println("---------------------------DELETE COURSE-----------S----------");
		dao.delete(55);
	}

}






