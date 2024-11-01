package com.ssw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.model.Employee;
import com.ssw.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void saveEmployee(Employee employee) {

		repo.save(employee);

	}

	@Override
	public Employee getEmployeeByEid(int eid) {

		if (repo.existsById(eid)) {
			return repo.findById(eid).get();
		} else
			return new Employee();

	}

	@Override
	public String deleteEmployeeByEid(int eid) {

		if (repo.existsById(eid)) {

			repo.deleteById(eid);

			return "employee deleted" + eid;

		} else
			return "Employee Not Found";

	}

	@Override
	public List<Employee> getAllEmployee() {

		return repo.findAll();
	}

}
