package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssw.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
