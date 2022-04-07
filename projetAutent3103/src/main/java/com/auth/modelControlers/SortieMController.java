package com.auth.modelControlers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth.entities.Admin;
import com.auth.entities.Sortie;
import com.auth.services.AdminService;
import com.auth.services.SortieService;

@Controller
public class SortieMController {
	
	@Autowired
	AdminService adminService;
	@Autowired 
	SortieService sortieService;
	
	@GetMapping("formulaireSortie")
	public String AfficherFormulaireSortie(Model m) {
		
		Sortie sortie=new Sortie();
		List<Admin> admins=adminService.findAll();
		m.addAttribute("admins", admins);
		m.addAttribute("sortie", sortie);
		String nomComplet="";
		m.addAttribute("nomComplet", nomComplet);
		
		return "gestionSortie";
		
	}
	
	@PostMapping("envoiSotrie")
	public String envoyerSortie(@Valid Sortie sortie,@RequestParam String nomComplet)
	{
		Admin admin1=adminService.searchParNomComplet(nomComplet);
		sortie.setAdmin(admin1);
		sortieService.saveSortie(sortie);
		
		return "redirect:/gestionSortie";
	}
	
	
	

}
