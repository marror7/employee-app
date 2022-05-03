package com.mateoArroyave.employees.backend.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long identificationNumber;
	private String identificationType;
	private String name;
	private String lastname;
	private Double salary;
	private String position;
	private Integer age;
	private String bondingTime;

	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="enter_date")
	private LocalDate enterDate;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getBondingTime() {
		return bondingTime;
	}
	public void setBondingTime(String bondingTime) {
		this.bondingTime = bondingTime;
	}	
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthdate) {
		this.birthDate = birthdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public LocalDate getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(LocalDate enterDate) {
		this.enterDate = enterDate;
	}
	public Long getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	
}
