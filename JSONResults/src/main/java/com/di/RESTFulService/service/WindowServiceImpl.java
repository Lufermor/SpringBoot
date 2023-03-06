package com.di.RESTFulService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.RESTFulService.dao.IMyWindowDao;
import com.di.RESTFulService.entity.MyWindow;
import com.di.RESTFulService.serviceImpl.IMyWindowService;

@Service
public class WindowServiceImpl implements IMyWindowService{
	
	@Autowired
	private IMyWindowDao windowDao;
	
	@Override
	public List<MyWindow> getAllWindows(){
		return windowDao.getAllWindows();
	}

}
