package com.siva.springbootdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		empRepository.findAll().forEach(employees::add);
		return employees;
	}

	public Employee getEmployee(Integer id) {
		return empRepository.findOne(id);
	}

	public void createEmployee(Employee emp) {
		empRepository.save(emp);
	}

	public void updateEmployee(Employee emp, int id) {
		empRepository.save(emp);
	}

	public void deleteEmployee(int id) {
		empRepository.delete(id);
	}

	public Employee getEmployeeByName(String name) {
		return empRepository.findByName(name);
	}

}
