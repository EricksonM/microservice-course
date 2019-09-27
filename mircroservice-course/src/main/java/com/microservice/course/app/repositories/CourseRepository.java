package com.microservice.course.app.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservice.course.app.documents.Course;

import reactor.core.publisher.Mono;

public interface CourseRepository extends ReactiveMongoRepository<Course, String>{

	public Mono<Course> findByName(String name);
	public Mono<Course> findByIdProfessor(String idProfessor);
}
