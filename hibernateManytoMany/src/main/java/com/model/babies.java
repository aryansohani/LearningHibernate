package com.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class babies {
	
	@Id
	private Integer bid;
	
	private String bname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<courses> courselist;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Set<courses> getCourselist() {
		return courselist;
	}

	public void setCourselist(Set<courses> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString()
	{
	    String coursesData = "";

	    if(courselist != null)
	    {
	        for(courses c : courselist)
	        {
	            coursesData += c.getCid() + ":" + c.getCname() + " ";
	        }
	    }

	    return "babies [bid=" + bid +
	           ", bname=" + bname +
	           ", courses=" + coursesData + "]";
	}
	

}
