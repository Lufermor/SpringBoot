package com.example.di.blackListClub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.di.blackListClub.entity.VipZone;
import com.example.di.blackListClub.service.IVipZoneService;

@Controller
public class VipZoneController {
	
	@Autowired
	private IVipZoneService vipZoneService;
	
	@RequestMapping("/vipzones")
	public String viewVipZonesPage(Model model) {
		List<VipZone> listVipzones = vipZoneService.listAll();
		model.addAttribute("listaVipzones", listVipzones);
		
		return "vipzones";
	}
	
	@RequestMapping("/newVipZone")
	public String showNewVipZonePage(Model model) {
		VipZone vipZone = new VipZone();
		model.addAttribute("vipZone", vipZone);
		
		return "new_vipZone";
	}
	
	@RequestMapping(value = "/saveVipZone", method = RequestMethod.POST)
	public String saveVipZone(@ModelAttribute("vipZone") VipZone vipZone) {
		vipZoneService.save(vipZone);
		
		return "redirect:/vipzones";
	}
	
	@RequestMapping("/editVipzone/{id}")
	public ModelAndView showEditVipZonePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_vipZone");
		VipZone vipZone = vipZoneService.get(id);
		mav.addObject("vipZone", vipZone);
		
		return mav;
	}
	
	@RequestMapping("/deleteVipzone/{id}")
	public String deleteVipZone(@PathVariable(name = "id") int id) {
		vipZoneService.delete(id);
		return "redirect:/vipzones";		
	}

}

