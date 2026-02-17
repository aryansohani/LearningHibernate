package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name ="Studenttable")
	public class Student {
		
		@Id
		@Column(name="SId")
		private Integer sid;
		
		@Column(name="Sname")
		private String sname;
		
		@Column(name="scity")
		private String scity;
		
		public Student()
		{
			System.out.println("zero param constrcutor for hibernate");
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

		public String getScity() {
			return scity;
		}

		public void setScity(String scity) {
			this.scity = scity;
		}

		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
		}
		
		
		

	}