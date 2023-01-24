package com.example.di.blackListClub.service;

import java.util.List;

import com.example.di.blackListClub.entity.ClienteVip;
import com.example.di.blackListClub.entity.VipZone;

public interface IClienteVipService {
	
	public List<ClienteVip> listAll();
	public void save(ClienteVip clienteVip);
	public ClienteVip get(long id);
	public void delete(long id);
	public List<ClienteVip> listByVipzone(VipZone vipzoneID);

}
