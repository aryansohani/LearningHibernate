package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class phone {
	
	@Id
	private Integer pid;
	
	private String pname;
	
	@Lob
	@Column(length=100000000)
	private byte [] image;
	
	@Lob
	private char [] textfile;
	
	public phone()
	{
		System.out.println("these is phone constructor");
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public char[] getTextfile() {
		return textfile;
	}

	public void setTextfile(char[] textfile) {
		this.textfile = textfile;
	}
	
	
	
	

}
