package com.di.RESTFulService.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.di.RESTFulService.entity.Greeting;

@Component
public class IWidgetDao {
	
	private List<Greeting> greetings = new ArrayList<>();
	
	public List<Greeting> getAllGreetings(){
		greetings.add(new Greeting("player1","Hola"));
		greetings.add(new Greeting("player2","cómo"));
		greetings.add(new Greeting("player3","estás"));
		greetings.add(new Greeting("player4","este"));
		greetings.add(new Greeting("player5","día"));
		greetings.add(new Greeting("player6","invernoso"));
		greetings.add(new Greeting("player7","azul"));
		greetings.add(new Greeting("player8","y amarillo."));
		return greetings;
	}

}
