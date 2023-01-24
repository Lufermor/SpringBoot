package com.example.di.blackListClub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.di.blackListClub.dao.IVipZoneDAO;
import com.example.di.blackListClub.entity.VipZone;
import com.example.di.blackListClub.service.IVipZoneService;

@Service
public class VipZoneServiceImpl implements IVipZoneService{
	
	@Autowired
	private IVipZoneDAO vipZoneDao;

	@Override
	public List<VipZone> listAll() {
		return vipZoneDao.findAll();
	}

	@Override
	public void save(VipZone vipZone) {
		vipZoneDao.save(vipZone);		
	}

	@Override
	public VipZone get(long id) {
		return vipZoneDao.findById(id).get();
	}

	@Override
	public void delete(long id) {
		vipZoneDao.deleteById(id);		
	}

}
