package com.ssw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.Book;

import com.ssw.model.Student;
import com.ssw.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping("/")
	public String checkApp() {

		return "App is working";

	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public String registerStudent(@RequestBody Student student) {
		System.out.println(student);
		service.registerStudent(student);

		return "Student Registered Succussfully";

	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@RequestBody Book book) {
		System.out.println(book);
		service.addBook(book);

		return "Book Added Succussfully";

	}

	@RequestMapping(value = "/addBookToStudent/{rollno}/{bid}", method = RequestMethod.PUT)
	public Student addBookToStudent(@PathVariable int rollno, @PathVariable int bid) {
		System.out.println(rollno + bid);

		return service.addBookToStudent(rollno, bid);

	}

	@RequestMapping(value = "/deleteStudentById/{rollno}", method = RequestMethod.DELETE)
	public String deleteStudentById(@PathVariable int rollno) {

		return service.deleteStudentById(rollno);

	}

	@RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
	public List<Student> getAllEmployee() {

		List<Student> elist = service.getAllStudent();

		return elist;

	}

	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public List<Book> getAllBooks() {

		List<Book> blist = service.getAllBooks();

		return blist;

	}

	@RequestMapping(value = "/getStudentByRollno/{rollno}", method = RequestMethod.GET)
	public Student getStudentByRollno(@PathVariable int rollno) {

		return service.getStudentByRollno(rollno);

	}

	@RequestMapping(value = "/removeBookfromStudent/{rollno}/{bid}", method = RequestMethod.PUT)
	public String removeBookfromStudent(@PathVariable int rollno,@PathVariable int bid) {

		return service.removeBookfromStudent(rollno, bid);

	}

}
