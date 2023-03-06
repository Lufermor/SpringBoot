package com.di.RESTFulService.entity;

public class Greeting {
	
	private Widget widget;
	
	public Greeting() {
		super();
	}

	public Greeting(Widget widget) {
		super();
		this.widget = widget;
	}

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

}