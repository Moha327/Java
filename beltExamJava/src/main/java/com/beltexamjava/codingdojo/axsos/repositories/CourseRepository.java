package com.beltexamjava.codingdojo.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.beltexamjava.codingdojo.axsos.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();

}
