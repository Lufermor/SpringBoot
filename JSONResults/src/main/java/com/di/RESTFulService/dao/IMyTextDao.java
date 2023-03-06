package com.di.RESTFulService.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.di.RESTFulService.entity.MyText;

@Component
public class IMyTextDao {
	
	private List<MyText> texts = new ArrayList<>();
	
	public List<MyText> getAllTexts(){
		texts.add(new MyText("Click Here",36, "bold", "text1", 250, 100, 
				"center", "sun1.opacity = (sun.opacity / 100 ) * 90;"));
		return texts;
	}

}
