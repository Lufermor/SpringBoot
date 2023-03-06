package com.di.RESTFulService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.di.RESTFulService.entity.MyWindow;

@Service
public interface IMyWindowService {
	
	List<MyWindow> getAllWindows();

}
