package com.di.RESTFulService.entity;

import java.util.ArrayList;
import java.util.List;

public class Widget {

	private List<Greeting> greetings;
	private String name;

	public Widget() {
		this.name = "name";
		this.greetings = new ArrayList<>();
	}
	
	public Widget(List<Greeting> greetings) {
		super();
		this.greetings = greetings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Greeting> getGreetings() {
		return greetings;
	}

	public void setGreetings(List<Greeting> greetings) {
		this.greetings = greetings;
	}
	
}
