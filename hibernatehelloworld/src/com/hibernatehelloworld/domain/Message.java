package com.hibernatehelloworld.domain;

public class Message {
	private int id;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public Message(String text) {
		super();
		this.text = text;
	}

	public Message() {
	}

	public void setText(String text) {
		this.text = text;
	}
}
