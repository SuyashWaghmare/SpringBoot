package com.ssw.service;

import java.util.List;

import com.ssw.model.Book;
import com.ssw.model.Student;

public interface StudentService {

	void registerStudent(Student student);

	void addBook(Book book);

	Student addBookToStudent(int rollno, int bid);

	String deleteStudentById(int rollno);

	List<Student> getAllStudent();

	List<Book> getAllBooks();

	Student getStudentByRollno(int rollno);

	String removeBookfromStudent(int rollno, int  bid);

	

}
