package com.example.crud;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDaoService serviceEmployee;
	Employee employee;
	
	@GetMapping("/employees")
	public Map<Integer, Employee> findAll() {
		return serviceEmployee.findAll();
	}

	@GetMapping("/employees/{id}")
	public Entry<Integer, Employee> findById(@PathVariable int id) {
		return serviceEmployee.findById(id);
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return serviceEmployee.addEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public Employee deleteEmployee(@PathVariable int id,Employee employee) {
		return serviceEmployee.deleteById(id, employee);
	}
//
//	@PutMapping("/updateEmployee/{id}")
//	public Employee updateEmployee(@PathVariable int id) {
//		return serviceEmployee.updateEmp(id);
//	}
}
