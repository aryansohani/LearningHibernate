package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class studentofclass {
	
	@Id
	private Integer sid;
	
	private String sname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private teacherofclass teacherlist;
	
	public studentofclass()
	{
		System.out.println("these is student constructor");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public teacherofclass getTeacherlist() {
		return teacherlist;
	}

	public void setTeacherlist(teacherofclass teacherlist) {
		this.teacherlist = teacherlist;
	}

	@Override
	public String toString() {
		return "studentofclass [sid=" + sid + ", sname=" + sname + 
		       ", teachername=" + (teacherlist != null ? teacherlist.getTname() : null) + "]";
	}
	
	

}
