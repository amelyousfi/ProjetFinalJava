
package com.auth.simpleControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entities.Admin;
import com.auth.repositories.AdminRepository;
import com.auth.services.AdminService;


@RestController
public class AdminController {
	
	@Autowired
	AdminRepository adminrepo;
	@Autowired
	AdminService adminservice;
	@GetMapping("listeAdmin")
	public List<Admin> listeAdmin() {
		return adminrepo.findAll();
	}
	@DeleteMapping("supprimerAdmin/{adminlogin}")
	public void deleteAdmin(@PathVariable String adminlogin)
	{
		adminservice.deleteAdmin(adminlogin);
	}
	@GetMapping("rechercheAdmin/{adminlogin}")
	public Optional<Admin> rechercheAdmin(@PathVariable String adminlogin){
		return adminservice.findAdminByAdminlogin(adminlogin);
	}
	
	@GetMapping("rechercheAdminParNom/{nomComplet}")
	public Admin rechercheAdminNomComplet(@PathVariable String nomComplet){
		return adminservice.searchParNomComplet(nomComplet);
	}
	/*
	
	@PostMapping("addAdmin")
	public Admin addAdmin(@Valid @RequestBody Admin admin) {
		adminservice.getBCPE();
		return adminservice.saveAdmin(admin);
		
		
	}*/
	

}


