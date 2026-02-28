package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class courses {
	
	@Id
	private Integer cid;
	
	private String cname;
	
	private Integer cprice;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<babies>babieslist;

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

	public Integer getCprice() {
		return cprice;
	}

	public void setCprice(Integer cprice) {
		this.cprice = cprice;
	}

	public Set<babies> getBabieslist() {
		return babieslist;
	}

	public void setBabieslist(Set<babies> babieslist) {
		this.babieslist = babieslist;
	}
	
	public courses()
	{
		System.out.println("constructor of courses");
	}

	@Override
	public String toString()
	{
	    String babiesData = "";

	    if(babieslist != null)
	    {
	        for(babies b : babieslist)
	        {
	            babiesData += b.getBid() + ":" + b.getBname() + " ";
	        }
	    }

	    return "courses [cid=" + cid +
	           ", cname=" + cname +
	           ", cprice=" + cprice +
	           ", babies=" + babiesData + "]";
	}
	


}
