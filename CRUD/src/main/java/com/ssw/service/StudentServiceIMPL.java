package com.ssw.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.model.Book;

import com.ssw.model.Student;
import com.ssw.repository.StudentRepository;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private BookRepository brepo;

	@Override
	public void registerStudent(Student student) {
		repo.save(student);

	}

	@Override
	public void addBook(Book book) {

		brepo.save(book);
	}

	@Override
	public Student addBookToStudent(int rollno, int bid) {
		if (repo.existsById(rollno) && brepo.existsById(bid))

		{
			Student student = repo.findById(rollno).get();
			Book book = brepo.findById(bid).get();

			List<Book> blist = student.getBlist();

			blist.add(book);

			repo.save(student);
			return student;

		} else
			return new Student();

	}

	@Override
	public String deleteStudentById(int rollno) {

		if (repo.existsById(rollno)) {

			repo.deleteById(rollno);

			return "Student deleted" + rollno;

		} else
			return "Student Not Found";

	}

	@Override
	public List<Student> getAllStudent() {

		return repo.findAll();
	}

	@Override
	public List<Book> getAllBooks() {
		return brepo.findAll();
	}

	@Override
	public Student getStudentByRollno(int rollno) {
		if (repo.existsById(rollno)) {

			return repo.findById(rollno).get();

		}

		else
			return new Student();

	}

	@Override
	public String removeBookfromStudent(int rollno, int bid) {

		if (repo.existsById(rollno) && brepo.existsById(bid)) {
			Student student = repo.findById(rollno).get();
			Book book = brepo.findById(bid).get();

			Iterator<Book> iterator = student.getBlist().iterator();
			while (iterator.hasNext()) {
				Book b = iterator.next();
				if (b.getBid() == bid) {
					iterator.remove();
					repo.save(student);
					return "Book removed from Student";
				}
			}

		}
		return "Book not found";

	}
}
