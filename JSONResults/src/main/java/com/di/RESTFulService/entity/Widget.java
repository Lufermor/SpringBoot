package com.di.RESTFulService.entity;

public class Widget {

	private String debug;
	private MyWindow window;
	private MyImage image;
	private MyText text;
	
	public Widget() {
		super();
	}

	public Widget(String debug, MyWindow window, MyImage image, MyText text) {
		super();
		this.debug = debug;
		this.window = window;
		this.image = image;
		this.text = text;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public MyWindow getWindow() {
		return window;
	}

	public void setWindow(MyWindow window) {
		this.window = window;
	}

	public MyImage getImage() {
		return image;
	}

	public void setImage(MyImage image) {
		this.image = image;
	}

	public MyText getText() {
		return text;
	}

	public void setText(MyText text) {
		this.text = text;
	}
	
}
