package com.di.RESTFulService.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.di.RESTFulService.entity.MyWindow;

@Component
public class IMyWindowDao {
	
	private List<MyWindow> windows = new ArrayList<>();
	
	public List<MyWindow> getAllWindows(){
		windows.add(new MyWindow("Sample Konfabulator Widget", "main_window", 500, 500));
		return windows;
	}

}
