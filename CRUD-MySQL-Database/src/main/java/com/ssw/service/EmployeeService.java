package com.ssw.service;

import java.util.List;

import com.ssw.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	Employee getEmployeeByEid(int eid);

	String deleteEmployeeByEid(int eid);

	List<Employee> getAllEmployee();

}
