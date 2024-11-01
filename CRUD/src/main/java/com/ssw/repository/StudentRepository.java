package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssw.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
