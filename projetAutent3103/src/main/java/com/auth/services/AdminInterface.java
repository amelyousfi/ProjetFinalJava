package com.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth.entities.Admin;



public interface AdminInterface {
	
	public BCryptPasswordEncoder getBCPE();
	
	public Admin saveAdmin(Admin admin);
	
	public  void  addRoleToUser(String adminlogin,String rolename);
	
	
	public List<Admin> findAll();
	
	
	public Optional<Admin> findAdminByAdminlogin(String adminlogin);
	public void deleteAdmin(String adminlogin);
	public Admin searchParAdminlogin(String adminlogin);
	public Admin searchParNomComplet(String nomComplet);


}
