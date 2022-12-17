package com.example.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDaoService {

	private static Map<Integer, Employee> map = new HashMap<>();
	private static int count = 3;

	static {
		Employee employee1 = new Employee(101, "John");
		Employee employee2 = new Employee(102, "peter");
		Employee employee3 = new Employee(103, "jackson");
		
		map.put(101, employee1);
		map.put(102, employee2);
		map.put(103, employee3);
	}
	
	//To Get all Employee
	public Map<Integer, Employee> findAll() {
		return map;
	}

	//To get specific Employee
	public Entry<Integer, Employee> findById(int id) {
		for (Entry<Integer, Employee> entry : map.entrySet()) {
			Integer key = entry.getKey();
			if (key == id) {
				return entry;
			}
		}
		return null;
	}

	//To add Employee Details
	public Employee addEmployee(Employee employee) {
		count += 1;
		employee.setId(count);
		map.put(count, employee);
		return employee;
	}

//	public Employee updateEmp(int id) {
//		
//	}

	//To delete Employee Details
	public Employee deleteById(int id,Employee employee) {
		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
			Integer key = entry.getKey();
			if(key == id) {
				map.remove(key);
				return employee;
			}
		}
		return null;
	}

}
