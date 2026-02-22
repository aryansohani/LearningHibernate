package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


	@Entity
	public class Teachers {
		
		@Id
		private Integer Tid;
		
		private String Tname;
		
		private String Tcity;

		public Integer getTid() {
			return Tid;
		}

		public void setTid(Integer tid) {
			Tid = tid;
		}

		public String getTname() {
			return Tname;
		}

		public void setTname(String tname) {
			Tname = tname;
		}

		public String getTcity() {
			return Tcity;
		}

		public void setTcity(String tcity) {
			Tcity = tcity;
		}
		
		public Teachers()
		{
			System.out.println("These is constructor");
		}

		@Override
		public String toString() {
			return "Teachers [Tid=" + Tid + ", Tname=" + Tname + ", Tcity=" + Tcity + "]";
		}
		
		
		

	}