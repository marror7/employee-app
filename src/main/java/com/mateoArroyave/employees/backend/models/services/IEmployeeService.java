package com.mateoArroyave.employees.backend.models.services;

import java.util.List;

import com.mateoArroyave.employees.backend.models.entity.Employee;

public interface IEmployeeService {
	public List<Employee> findAll();
	
	public Employee save(Employee employee);
	
	public Employee findById(Long id);
	
	public void delete(Long id);
}
