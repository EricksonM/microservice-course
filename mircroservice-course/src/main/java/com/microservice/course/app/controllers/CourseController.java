package com.microservice.course.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.course.app.documents.Course;
import com.microservice.course.app.services.CourseServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CourseController {

	@Autowired
	private CourseServiceImpl _courseService;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Course>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseService.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Mono<Course>> create(@RequestBody Course course){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseService.save(course));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Mono<Course>> update(@RequestBody Course course, @PathVariable String id){
		Mono<Course> courseDB = _courseService.getById(id).flatMap(co -> {
			co.setName(course.getName());
			co.setMin(course.getMin());
			co.setMax(course.getMax());
			co.setIdProfessor(course.getIdProfessor());
			co.setStatus(course.getStatus());
			
			return _courseService.save(co);
		});
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(courseDB);
	}
	
	@DeleteMapping("/id/{id}")
	public Mono<Void> deleteById(@PathVariable String id){
		return _courseService.delete(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Mono<Course>> getByName(@PathVariable String name){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseService.getByName(name));
	}
	
	@GetMapping("/idProfessor/{idProfessor}")
	public ResponseEntity<Mono<Course>> getByIdProfessor(@PathVariable String idProfessor){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseService.getByIdProfessor(idProfessor));
	}
	
	
}





