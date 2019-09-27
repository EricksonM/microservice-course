package com.microservice.course.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.app.documents.Course;
import com.microservice.course.app.repositories.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseRepository _courseRepo;
	
	@Override
	public Flux<Course> getAll() {
		return _courseRepo.findAll();
	}

	@Override
	public Mono<Course> save(Course course) {
		return _courseRepo.save(course);
	}

	@Override
	public Mono<Void> delete(String id) {
		return _courseRepo.deleteById(id);
	}

	@Override
	public Mono<Course> getById(String id) {
		return _courseRepo.findById(id);
	}

	@Override
	public Mono<Course> getByName(String name) {
		return _courseRepo.findByName(name);
	}

	@Override
	public Mono<Course> getByIdProfessor(String idProfessor) {
		return _courseRepo.findByIdProfessor(idProfessor);
	}

}
