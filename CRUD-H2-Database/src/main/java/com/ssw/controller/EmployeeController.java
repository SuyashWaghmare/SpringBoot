package com.ssw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.Employee;
import com.ssw.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/")
	public String check() {

		return "check method called";
	}

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {

		List<Employee> elist = service.getAllEmployee();


		return elist;

	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
		System.out.println(employee);

		return "Employee Saved";
	}

	@RequestMapping(value = "/getEmployeeByEid/{eid}", method = RequestMethod.GET)
	public Employee getEmployeeByEid(@PathVariable int eid) {

		return service.getEmployeeByEid(eid);

	}

	@RequestMapping(value = "/deleteEmployeeByEid/{eid}", method = RequestMethod.DELETE)
	public String deleteEmployeeByEid(@PathVariable int eid) {

		return service.deleteEmployeeByEid(eid);

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {

		service.saveEmployee(employee);
		return employee;

	}

}
