package com.praticetempletes.JdbcTempletesDemo.entity;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcDAO {

	private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class);

	private JdbcTemplate jdbcTemplate;

	public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	RowMapper<Course> rowMapper = (rs, rowNum) -> {
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setTitle(rs.getString("title"));
		course.setDescription(rs.getString("description"));
		course.setLink(rs.getString("link"));
		return course;
	};

	public List<Course> getcourselist() {
		String sql = "select courseId, title, description, link from Course";
		return jdbcTemplate.query(sql,rowMapper);
	}

	public Optional<Course> getCourse(int id) {  //getCourse(1234)
		Course course = null;
		String sql = "select courseId,title,description,link from course where courseId = ?";

		course =  jdbcTemplate.queryForObject(sql,rowMapper,new Object[]{id});

		//		}catch(DataAccessException e) {
		//			log.info("course is not foundfor the id" +Id);
		//		}
		return Optional.ofNullable(course);

	}
	public void create(Course course) {
		String sql = "insert into Course values (?,?,?,?)";
		int output = jdbcTemplate.update(sql,course.getCourseId(),course.getTitle(),course.getDescription(),course.getLink());
		if(output == 1) {
			log.info("new course is created : ");	

		}
	}

	public void update(Course course, int Id) {
		String sql = "update Course set title = ?,description = ?,link = ? where courseId = ?";
		int output = jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink(),Id);
		if(output == 1) {
			log.info("updated Course is created : ");	
		}
			}
		public void delete(int Id) {
			String sql = "delete from Course where courseId = ?";
			int output = jdbcTemplate.update(sql,Id);
			if(output == 1) {
				log.info("delete Course is created with Id: "+Id);	
			}
		}

	
}




