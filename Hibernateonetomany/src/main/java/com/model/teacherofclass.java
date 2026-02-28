package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class teacherofclass {
	
	@Id
	private Integer tid;
	
	private String tname;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<studentofclass>studentlist;
	
	public teacherofclass()
	{
		System.out.println("these is teacher constructor");
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<studentofclass> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<studentofclass> studentlist) {
		this.studentlist = studentlist;
	}

	@Override
	public String toString() {
		return "teacherofclass [tid=" + tid + ", tname=" + tname + ", studentlist=" + studentlist + "]";
	}
	

}
