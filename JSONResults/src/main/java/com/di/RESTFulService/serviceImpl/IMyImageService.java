package com.di.RESTFulService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.di.RESTFulService.entity.MyImage;

@Service
public interface IMyImageService {
	
	List<MyImage> getAllImages();

}
