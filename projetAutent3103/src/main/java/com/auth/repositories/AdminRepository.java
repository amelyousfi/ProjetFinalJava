package com.auth.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	public Admin findByAdminlogin(String adminlogin);
	public Admin findByNomComplet(String nomComplet);
	
}
