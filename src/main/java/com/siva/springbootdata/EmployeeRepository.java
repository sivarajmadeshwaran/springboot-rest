package com.siva.springbootdata;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	public Employee findByName(String name);

}
