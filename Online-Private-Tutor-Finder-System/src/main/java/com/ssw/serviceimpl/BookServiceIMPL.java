package com.ssw.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.model.Book;
import com.ssw.repository.BookRepository;
import com.ssw.service.BookService;

@Service
public class BookServiceIMPL implements BookService {

	@Autowired
	private BookRepository bookrepo;

	@Override
	public void addBooks(Book book) {
		bookrepo.save(book);

	}

	@Override
	public List<Book> viewAllEbooks() {

		return bookrepo.findAll();
	}

}
