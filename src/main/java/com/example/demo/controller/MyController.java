package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

//@RestController
@Controller
public class MyController {
	
	@RequestMapping("/")
	String indexPage(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("stud", student);
		
		return "index.html";
	}
	
	@Autowired
	StudentRepository stud_repo;
	@RequestMapping("/register")
	String registerStudent(@ModelAttribute("stud") Student s) {
		
		stud_repo.save(s);
		
		System.out.println("Hellooo, Data registered.");
		
		return "redirect:viewall";
	}
	
	
	
	@RequestMapping("viewall")
	String ViewAll(Model model) {
		
		List list = stud_repo.findAll();
		
		model.addAttribute("all_Students", list);
		return "view.html";
	}
	
	@RequestMapping("edit/{id}")
	String edit(@PathVariable("id") int id,Model model) {
		
	  Student s = stud_repo.getById(id);
	  model.addAttribute("stud",s);
	  System.out.println(s);
		
		return "edit-data.html";
	}
	
	@RequestMapping("update")
	String update(@ModelAttribute("stud") Student s) {
		
		
	System.out.println("data up:" +s);
		
	  stud_repo.save(s);
	  System.out.println("Data updated.");
		
		return "redirect:/viewall";
	}
	
	@RequestMapping("delete/{id}")
	String delete(@PathVariable("id") int id,Model model) {
		
	  stud_repo.delete(stud_repo.getById(id));
		
		return "redirect:/viewall";
	}

}
