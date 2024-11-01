package com.ssw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.Admin;
import com.ssw.model.Book;
import com.ssw.model.Parent;
import com.ssw.model.Tutor;
import com.ssw.service.AdminService;
import com.ssw.service.BookService;
import com.ssw.service.ParentService;
import com.ssw.service.TutorService;

@RestController
@RequestMapping("/admin-api")
public class AdminController {

	@Autowired
	private AdminService adminservice;

	@Autowired
	private TutorService tutorservice;

	@Autowired
	private BookService bookservice;


	@Autowired
	private ParentService parentservice;

	@RequestMapping("/")
	public String Check() {
		return "Hello";
	}

	@PostMapping("/loginSave")
	ResponseEntity<Admin> loginSave(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminservice.loginSave(admin), HttpStatus.CREATED);
	}

	@PostMapping("/adminLogin")
	ResponseEntity<String> adminLogin(@RequestBody Admin admin) {
		return new ResponseEntity<String>(adminservice.adminLogin(admin), HttpStatus.OK);
	}

	@PostMapping("/addTutorByAdmin")
	ResponseEntity<String> addTutorByAdmin(@RequestBody Tutor tutor) {

		if (tutor.getTutorid() == 0 || tutor.getTutorname().trim().isEmpty() || tutor.getExperience() == 0.0
				|| tutor.getMobileno() == 0 || tutor.getMailid().trim().isEmpty()
				|| tutor.getUsername().trim().isEmpty() || tutor.getPassword().trim().isEmpty()) {
			return new ResponseEntity<String>("Not Accepted", HttpStatus.NOT_ACCEPTABLE);
		}

		tutorservice.addTutor(tutor);

		return new ResponseEntity<String>("Tutor Added Successfully", HttpStatus.CREATED);
	}

	@PostMapping("/addBooksByAdmin")
	ResponseEntity<String> addBooksByAdmin(@RequestBody Book book) {

		if (book.getBookid() == 0 || book.getBookname().trim().isEmpty()) {
			return new ResponseEntity<String>("Not Accepted", HttpStatus.NOT_ACCEPTABLE);
		}

		bookservice.addBooks(book);

		return new ResponseEntity<String>("Book Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/viewAllParents")
	ResponseEntity<List<Parent>> viewAllParents() {
		return new ResponseEntity<List<Parent>>(parentservice.viewAllParents(), HttpStatus.OK);

	}

}
