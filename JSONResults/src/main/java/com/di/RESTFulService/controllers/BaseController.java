package com.di.RESTFulService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.di.RESTFulService.entity.Greeting;
import com.di.RESTFulService.entity.Widget;
import com.di.RESTFulService.serviceImpl.IMyImageService;
import com.di.RESTFulService.serviceImpl.IMyTextService;
import com.di.RESTFulService.serviceImpl.IMyWindowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
 
@RestController
@RequestMapping("/api")
public class BaseController {

	@Autowired
	private IMyImageService imageService;
	@Autowired
	private IMyTextService textService;
	@Autowired
	private IMyWindowService windowService;

	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/widget")
    @ResponseBody
    public Greeting message() {
 
    	Greeting greeting = new Greeting();
    	Widget widget = new Widget();
    	widget.setDebug("on");
    	widget.setImage(imageService.getAllImages().get(0));
    	widget.setText(textService.getAllTexts().get(0));
    	widget.setWindow(windowService.getAllWindows().get(0));
    	greeting.setWidget(widget);
        return greeting;
    }
    
    @RequestMapping("/all")
    @ResponseBody
    public ResponseEntity<String> message2() throws JsonProcessingException {
    	//con s.todo() devolvemos una lista de objetos que son convertidos s JSON 
    	//utilizando la biblioteca "ObjectMapper" de Jackson.
    	
    	Greeting greeting = new Greeting();
    	Widget widget = new Widget();
    	widget.setDebug("on");
    	widget.setImage(imageService.getAllImages().get(0));
    	widget.setText(textService.getAllTexts().get(0));
    	widget.setWindow(windowService.getAllWindows().get(0));
    	greeting.setWidget(widget);
       
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(greeting);
        //se crea un objeto HttpHeaders que establece el tipo de contenido de la respuetsa en "MediaType.APPLICATION_JSON".
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //luego se crea un objeto que incluye el cuerpo de la respuesta Json, las cabeceras y el estado HTTP.
        //Finalmente, la función devuelve la respuesta utilizando el método "ok()" de ResponseEntity, 
        //que establece el estado HTTP en 200 OK, y el método "body()", que establece el cuerpo de la 
        //respuesta en el JSON generado.
        return ResponseEntity.ok().headers(headers).body(json);
    }
 
}
