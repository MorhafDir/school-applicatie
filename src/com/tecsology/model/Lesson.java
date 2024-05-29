package com.tecsology.model;

public class Lesson {

	private String title;
	private String context;
	
	
	public Lesson(String title, String context) {
		super();
		this.title = title;
		this.context = context;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}
	
	
	
	
}
