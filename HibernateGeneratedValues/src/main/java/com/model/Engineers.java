package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Engineers {
	
	@Id
	@GeneratedValue(generator="my_seq",strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="my_seq",sequenceName="gg",initialValue=100,allocationSize=3)
	private Integer id;
	
	private String name;
	
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Engineers() {
		System.out.println("constructor");
	}

	@Override
	public String toString() {
		return "Engineers [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
