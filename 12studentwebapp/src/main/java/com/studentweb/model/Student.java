package com.studentweb.model;
public class Student {
	private int id;
	private String fname;
	private String lname;
	private String email;
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.fname = firstName;
		this.lname = lastName;
		this.email = email;
	}
	public Student(String firstName, String lastName, String email) {
		super();
		this.fname = firstName;
		this.lname = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return fname;
	}
	public void setFirstName(String firstName) {
		this.fname = firstName;
	}
	public String getLastName() {
		return lname;
	}
	public void setLastName(String lastName) {
		this.lname = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", email=" + email + "]";
	}
	
	
}
