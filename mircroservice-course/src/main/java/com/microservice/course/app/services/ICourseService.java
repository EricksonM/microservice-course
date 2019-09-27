package com.microservice.course.app.services;

import com.microservice.course.app.documents.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICourseService {

	public Flux<Course> getAll();
	public Mono<Course> save(Course course);
	public Mono<Void> delete(String id);
	public Mono<Course> getById(String id);
	public Mono<Course> getByName(String name);
	public Mono<Course> getByIdProfessor(String idProfessor);
	
}
