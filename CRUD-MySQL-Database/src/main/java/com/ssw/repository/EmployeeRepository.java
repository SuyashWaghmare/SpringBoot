package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssw.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
}
