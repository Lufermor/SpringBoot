package com.example.di.blackListClub.service;

import java.util.List;

import com.example.di.blackListClub.entity.VipZone;

public interface IVipZoneService {
	
	public List<VipZone> listAll();
	public void save(VipZone vipZone);
	public VipZone get(long id);
	public void delete(long id);

}
