package com.di.RESTFulService.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.RESTFulService.dao.IWidgetDao;
import com.di.RESTFulService.entity.Greeting;
import com.di.RESTFulService.service.IWidgetService;

@Service
public class WidgetServiceImpl implements IWidgetService{
	
	@Autowired
	private IWidgetDao widgetDao;
	
	@Override
	public List<Greeting> getAllGreetings(){
		return widgetDao.getAllGreetings();
	}

}
