package com.ssw.service;

import java.util.List;

import com.ssw.model.Book;

public interface BookService {

	void addBooks(Book book);

	List<Book> viewAllEbooks();

}
