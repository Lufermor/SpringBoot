package com.di.RESTFulService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.di.RESTFulService.entity.MyText;

@Service
public interface IMyTextService {
	
	List<MyText> getAllTexts();

}
