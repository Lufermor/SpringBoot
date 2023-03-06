package com.di.RESTFulService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.di.RESTFulService.entity.Widget;
import com.di.RESTFulService.service.IWidgetService;
 
@RestController
@RequestMapping("/api")
public class BaseController {

	@Autowired
	private IWidgetService widgetService;

	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/saluda")
    public Widget message() {
 
    	Widget widget = new Widget();
    	widget.setGreetings(widgetService.getAllGreetings());
        return widget;
    }
    
    @RequestMapping("/saluda/{name}")
    public Widget message2(@PathVariable String name) {
 
    	Widget widget = new Widget();
    	widget.setName(name);
    	widget.setGreetings(widgetService.getAllGreetings());
        return widget;
    }
 
}
