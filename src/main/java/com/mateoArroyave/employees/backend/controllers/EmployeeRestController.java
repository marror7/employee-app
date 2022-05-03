package com.mateoArroyave.employees.backend.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mateoArroyave.employees.backend.models.entity.Employee;
import com.mateoArroyave.employees.backend.models.services.IEmployeeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> index(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/employee")
	public Employee show(@RequestParam Long identificationNumber, 
							@RequestParam String identificationType,
							@RequestParam String name,
							@RequestParam String lastname,
							@RequestParam String position,
							@RequestParam Double salary,
							@RequestParam String birthDate,
							@RequestParam String enterDate){
		
		Employee employee = new Employee();
		employee.setIdentificationNumber(identificationNumber);
		employee.setIdentificationType(identificationType);
		employee.setName(name);
		employee.setLastname(lastname);
		employee.setPosition(position);
		employee.setSalary(salary);
		LocalDate birth = LocalDate.parse(birthDate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
		employee.setBirthDate(birth);
		LocalDate enter = LocalDate.parse(enterDate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
		employee.setEnterDate(enter);

		return create(employee);
	}
	
	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody Employee employee){	
		
		int bondingDays = Period.between(employee.getEnterDate(), LocalDate.now()).getDays();
		int bondingMonths = Period.between(employee.getEnterDate(), LocalDate.now()).getMonths();
		int bondingYears = Period.between(employee.getEnterDate(), LocalDate.now()).getYears();
		employee.setBondingTime(bondingYears + " Years "
								+ bondingMonths + " Months " 
								+ bondingDays + " Days" );
		Period age = Period.between(employee.getBirthDate(), LocalDate.now());
		employee.setAge(age.getYears());
		return employeeService.save(employee);		
	}
		
	@PutMapping("/employees/{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable Long id){
		Employee current = employeeService.findById(id);
		
		current.setIdentificationNumber(employee.getIdentificationNumber());
		current.setIdentificationType(employee.getIdentificationType());
		current.setName(employee.getName());
		current.setLastname(employee.getLastname());
		current.setPosition(employee.getPosition());
		current.setSalary(employee.getSalary());
		current.setBirthDate(employee.getBirthDate());
		current.setEnterDate(employee.getEnterDate());
		
		return employeeService.save(current);
	}
	
	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		employeeService.delete(id);
	}
}
