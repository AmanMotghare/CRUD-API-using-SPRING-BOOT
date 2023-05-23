package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class MyRESTcontroller {
	
	@Autowired
	StudentRepository repo;
	
	@RequestMapping("/studentAPI")
	List<Student> getAllStudentsAPI() {
		
		List<Student> list =  repo.findAll();
		
		return list;
	}

}
