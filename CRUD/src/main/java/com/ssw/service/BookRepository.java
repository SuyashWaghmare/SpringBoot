package com.ssw.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssw.model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
