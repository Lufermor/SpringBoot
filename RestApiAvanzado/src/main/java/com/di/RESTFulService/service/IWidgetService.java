package com.di.RESTFulService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.di.RESTFulService.entity.Greeting;

@Service
public interface IWidgetService {
	
	List<Greeting> getAllGreetings();

}
