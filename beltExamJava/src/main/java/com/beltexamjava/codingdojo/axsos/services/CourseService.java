package com.beltexamjava.codingdojo.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.beltexamjava.codingdojo.axsos.models.Course;
import com.beltexamjava.codingdojo.axsos.repositories.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	
	
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	//find all
	public List<Course> findAllCourses(){
		return courseRepository.findAll();
	}
	
	//find by id
	
	public Course findCourseById(Long id) {
		Optional<Course> myCourse = courseRepository.findById(id);
		if(myCourse.isPresent()) {
			return myCourse.get();
		}else {
			return null;
		}
	}
	
	//create course
	public Course createCourse(Course myCourse) {
		return courseRepository.save(myCourse);
	}
	//update course
	public void updateCourse(Course myCourse) {
		courseRepository.save(myCourse);
	}
	//delete course
	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}

}
