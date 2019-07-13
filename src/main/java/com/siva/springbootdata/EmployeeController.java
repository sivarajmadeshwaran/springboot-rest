package com.siva.springbootdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sivaraj
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//By Default spring boot returns json as response
	@RequestMapping("/employees")
	public List<Employee> getAll() {
		return empService.getAllEmployees(); 
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}
	
	@RequestMapping("/employees/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return empService.getEmployeeByName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="employees")
	public void addEmployee(Employee emp){
		empService.createEmployee(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="employees/{id}")
	public void updateEmployee(@RequestBody Employee emp,@PathVariable int id){
		empService.updateEmployee(emp,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		empService.deleteEmployee(id);
	}

}
