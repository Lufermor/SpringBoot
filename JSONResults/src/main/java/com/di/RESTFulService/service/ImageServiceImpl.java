package com.di.RESTFulService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.RESTFulService.dao.IMyImageDao;
import com.di.RESTFulService.entity.MyImage;
import com.di.RESTFulService.serviceImpl.IMyImageService;

@Service
public class ImageServiceImpl implements IMyImageService{
	
	@Autowired
	private IMyImageDao imageDao;
	
	@Override
	public List<MyImage> getAllImages(){
		return imageDao.getAllImages();
	}

}
