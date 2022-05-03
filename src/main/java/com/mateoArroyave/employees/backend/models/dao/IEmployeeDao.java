package com.mateoArroyave.employees.backend.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mateoArroyave.employees.backend.models.entity.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Long>{

}
