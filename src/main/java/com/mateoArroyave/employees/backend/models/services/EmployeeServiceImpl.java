package com.mateoArroyave.employees.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mateoArroyave.employees.backend.models.dao.IEmployeeDao;
import com.mateoArroyave.employees.backend.models.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		employeeDao.deleteById(id);
	}

}
