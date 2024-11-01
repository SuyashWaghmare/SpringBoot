package com.ssw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.Employee;

@RestController
@RequestMapping("/emp-api")
public class EmployeeController {

	@GetMapping(value = "/getAllEmployee", produces = { "application/json" })
	public ResponseEntity<List<Employee>> getAllData() {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(101, "Suyash", "Pune"));
		emp.add(new Employee(102, "Rohit", "Pimpri"));
		emp.add(new Employee(103, "Daemon", "KingsLanding"));

		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);

	}

}
