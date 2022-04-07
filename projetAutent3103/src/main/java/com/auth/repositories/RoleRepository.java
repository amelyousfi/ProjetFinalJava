package com.auth.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	Role findByRolename(String rolename);
	List<Role> findAll();


}
