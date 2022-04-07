package com.auth.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entities.Admin;
import com.auth.entities.Role;
import com.auth.repositories.AdminRepository;
import com.auth.repositories.RoleRepository;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
@Transactional
public class AdminService implements AdminInterface {
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RoleRepository roleRepository;
	@Bean
	// avoir un BCryptEncoder qui est initialisÃ© une et une seule fois
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	public Admin saveAdmin(Admin admin) {
		String hashPW=this.getBCPE().encode(admin.getPassword());
		
		System.out.print(hashPW);
		admin.setPassword(hashPW);
		return adminRepository.save(admin);
		
		
	}
	
	public void addRoleToUser(String adminlogin, String rolename) {
		// TODO Auto-generated method stub
	
		Role role=(Role) roleRepository.findByRolename(rolename);
		Admin admin1=adminRepository.findByAdminlogin(adminlogin);
		admin1.getRoles().add(role);
	}



	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}



	@Override
	public Optional<Admin> findAdminByAdminlogin(String adminlogin) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminlogin);
	}



	@Override
	public void deleteAdmin(String adminlogin) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(adminlogin);
	}



	@Override
	public Admin searchParAdminlogin(String adminlogin) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Admin searchParNomComplet(String nomComplet) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	

}
