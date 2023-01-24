package com.example.di.blackListClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.di.blackListClub.entity.VipZone;

	@Repository
	public interface IVipZoneDAO extends JpaRepository<VipZone, Long>{
		@Query("select vz from VipZone vz where vz.zona like ?1 ")
		public VipZone findByName(String zona);

	}
