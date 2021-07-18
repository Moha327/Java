package com.codingdojo.firstproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.firstproject.models.Course;
import com.codingdojo.firstproject.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	
	
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> findAllCourses(){
		return courseRepository.findAll();
	}
	
	
	
	public Course findCourseById(Long id) {
		Optional<Course> myCourse = courseRepository.findById(id);
		if(myCourse.isPresent()) {
			return myCourse.get();
		}else {
			return null;
		}
	}
	
	
	public Course createCourse(Course myCourse) {
		return courseRepository.save(myCourse);
	}
	
	public void updateCourse(Course myCourse) {
		courseRepository.save(myCourse);
	}
	
	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}

}