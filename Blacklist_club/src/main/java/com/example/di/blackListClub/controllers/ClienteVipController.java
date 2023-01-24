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

import com.example.di.blackListClub.entity.ClienteVip;
import com.example.di.blackListClub.entity.VipZone;
import com.example.di.blackListClub.service.IClienteVipService;
import com.example.di.blackListClub.service.IVipZoneService;

@Controller
public class ClienteVipController {
	
	@Autowired
	private IClienteVipService clienteVipService;
	@Autowired
	private IVipZoneService vipZoneService;
	
	@RequestMapping("/clientesVipzone/{id}")
	public String viewClientesVipZonePage(Model model, @PathVariable(name = "id") int vipzoneID) {
		VipZone vipZone = vipZoneService.get(vipzoneID);
		List<ClienteVip> listClientesVip = clienteVipService.listByVipzone(vipZone);
		model.addAttribute("listaVipClientes", listClientesVip);
		model.addAttribute("vipZone", vipZone);
		
		return "clientesVipZone";
	}
	
	@RequestMapping("/newVipCliente/{id}")
	public String showNewVipClientePage(Model model, @PathVariable(name = "id") int vipzoneID) {
		ClienteVip clienteVip = new ClienteVip();
		VipZone vipZone = vipZoneService.get(vipzoneID);
		clienteVip.setVipzone(vipZone);
		model.addAttribute("clienteVip", clienteVip);
		
		return "new_ClienteVip";
	}
	
	@RequestMapping(value = "/saveClienteVip", method = RequestMethod.POST)
	public String saveVipZone(@ModelAttribute("clienteVip") ClienteVip clienteVip) {
		clienteVipService.save(clienteVip);
		
		return "redirect:/clientesVipzone/" + clienteVip.getVipzone().getId();
	}
	
	@RequestMapping("/editVipcliente/{id}")
	public ModelAndView showEditVipZonePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_clienteVip");
		ClienteVip clienteVip = clienteVipService.get(id);
		mav.addObject("clienteVip", clienteVip);
		return mav;
	}
	
	@RequestMapping("/deleteVipcliente/{id}")
	public String deleteVipZone(@PathVariable(name = "id") int id) {
		ClienteVip clienteVip = clienteVipService.get(id);
		Long vipZoneId = clienteVip.getVipzone().getId();
		clienteVipService.delete(clienteVip.getId());
		return "redirect:/clientesVipzone/" + vipZoneId;		
	}

}

