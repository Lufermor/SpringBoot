package com.di.RESTFulService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.RESTFulService.dao.IMyTextDao;
import com.di.RESTFulService.entity.MyText;
import com.di.RESTFulService.serviceImpl.IMyTextService;

@Service
public class TextServiceImpl implements IMyTextService{
	
	@Autowired
	private IMyTextDao textDao;
	
	@Override
	public List<MyText> getAllTexts(){
		return textDao.getAllTexts();
	}

}
