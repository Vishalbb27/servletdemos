package com.tags;

public class Student {
	private String fname;
	private String lname;
	private boolean above90;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public boolean isAbove90() {
		return above90;
	}
	public void setAbove90(boolean above90) {
		this.above90 = above90;
	}
	public Student(String fname, String lname, boolean above90) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.above90 = above90;
	}
	
	
}
