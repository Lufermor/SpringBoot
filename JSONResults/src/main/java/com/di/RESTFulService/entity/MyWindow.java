package com.di.RESTFulService.entity;

public class MyWindow {
	
	private String tittle;
	private String name;
	private int width;
	private int height;
	
	public MyWindow() {
		super();
	}

	public MyWindow(String tittle, String name, int width, int height) {
		super();
		this.tittle = tittle;
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
