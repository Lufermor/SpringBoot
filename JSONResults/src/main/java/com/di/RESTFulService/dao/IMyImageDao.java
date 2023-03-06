package com.di.RESTFulService.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.di.RESTFulService.entity.MyImage;

@Component
public class IMyImageDao {
	
	private List<MyImage> images = new ArrayList<>();
	
	public List<MyImage> getAllImages(){
		images.add(new MyImage("Images/Sun.png","sun1", 250, 250, "center"));
		return images;
	}

}
