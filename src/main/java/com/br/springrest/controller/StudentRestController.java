package com.br.springrest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.springrest.entity.Student;
import com.br.springrest.entity.StudentErrorResponse;
import com.br.springrest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();

		Student joao = new Student("Joao", "Silva");
		Student bia = new Student("Beatriz", "Messias");
		Student mari = new Student("Marilene", "Callerani");
		Student orlando = new Student("Orlando", "Silva");

		students.addAll(Arrays.asList(joao, bia, mari, orlando));
	}

	@GetMapping("/students")
	public List<Student> showStudentList() {

		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student showStudentById(@PathVariable int studentId) {

		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return students.get(studentId);
	}
}
