package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {
	
	@Id
	private Integer id;
	
	private String ename;
	
	private Integer age;

	@Transient
	private String city;

	public Integer getId() {
		return id;
	}
	
	public Employee()
	{
		System.out.println("these is constructor");
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", age=" + age + ", city=" + city + "]";
	}
	
	
	
	
	
	

}