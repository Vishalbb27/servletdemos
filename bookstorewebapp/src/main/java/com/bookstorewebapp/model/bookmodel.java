package com.bookstorewebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class bookmodel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int price;
	private String isbn;
	public String getIsbn() {
		return isbn;
	}
	
	public bookmodel() {}
	@Override
	public String toString() {
		return "bookmodel [id=" + id + ", name=" + name + ", price=" + price + ", isbn=" + isbn + "]";
	}

	public bookmodel(String isbn, String name, int price) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
