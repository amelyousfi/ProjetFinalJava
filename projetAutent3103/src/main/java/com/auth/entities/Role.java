package com.auth.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	private String rolename;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public Role() {
		super();
	}

}
