package com.example.di.blackListClub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.di.blackListClub.dao.IClienteVipDAO;
import com.example.di.blackListClub.entity.ClienteVip;
import com.example.di.blackListClub.entity.VipZone;
import com.example.di.blackListClub.service.IClienteVipService;

@Service
public class ClienteVipServiceImpl implements IClienteVipService{
	
	@Autowired
	private IClienteVipDAO clienteVipDAO;

	@Override
	public List<ClienteVip> listAll() {
		return clienteVipDAO.findAll();
	}

	@Override
	public void save(ClienteVip clienteVip) {
		clienteVipDAO.save(clienteVip);	
	}

	@Override
	public ClienteVip get(long id) {
		return clienteVipDAO.findById(id).get();
	}

	@Override
	public void delete(long id) {
		clienteVipDAO.deleteById(id);	
	}

	@Override
	public List<ClienteVip> listByVipzone(VipZone vipzoneID) {
		return clienteVipDAO.findByVipzone(vipzoneID);
	}

}
