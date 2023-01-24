package com.example.di.blackListClub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.di.blackListClub.entity.ClienteVip;
import com.example.di.blackListClub.entity.VipZone;

public interface IClienteVipDAO extends JpaRepository<ClienteVip, Long>{
	
	@Query("select cv from ClienteVip cv where cv.dni like ?1 ")
	public ClienteVip findByDni(String dni);
	
//	@Query("select c from ClienteVip c where c.vipzone_id = ?1 ")
	public List<ClienteVip> findByVipzone(VipZone vipzoneID);
	
}
