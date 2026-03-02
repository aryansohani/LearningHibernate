package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
	
	@Id
	private Integer cid;
	
	private String cname;
	
	private String cgrade;
	
	public College()
	{
		System.out.print("these is constructor");
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCgrade() {
		return cgrade;
	}

	public void setCgrade(String cgrade) {
		this.cgrade = cgrade;
	}

	@Override
	public String toString() {
		return "College [cid=" + cid + ", cname=" + cname + ", cgrade=" + cgrade + "]";
	}
	
	
	


}
