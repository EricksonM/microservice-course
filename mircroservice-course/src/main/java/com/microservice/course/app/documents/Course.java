package com.microservice.course.app.documents;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "course")
public class Course implements Serializable {

	private String id;
	private String name;
	private Integer min;
	private Integer max;
	private String idProfessor;
	private String status;

	private static final long serialVersionUID = 692128564136927141L;



}
