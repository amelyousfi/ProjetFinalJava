package com.auth.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin  implements Serializable {
	private static final long serialVersionUID = 1L;
	
@Id	
@NotNull(message="le adminlogin ne doit pas etre null")
private String adminlogin;
private int active;
@NotNull(message="le password ne doit pas etre null")
private String password;
@NotNull(message="le nomComplet ne doit pas etre null")
@Size(min=4,max=50)
private String nomComplet;
@NotNull(message="l adress ne doit pas etre null")
private String adress;
@NotNull(message="le numero de tel ne doit pas etre null")
private String telephone;

@ManyToMany(fetch = FetchType.EAGER)
private Collection<Role> roles=new ArrayList<Role>();
public String getAdminlogin() {
	return adminlogin;
}
public void setAdminlogin(String adminlogin) {
	this.adminlogin = adminlogin;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Collection<Role> getRoles() {
	return roles;
}
public void setRoles(Collection<Role> roles) {
	this.roles = roles;
}
public String getNomComplet() {
	return nomComplet;
}
public void setNomComplet(String nomComplet) {
	this.nomComplet = nomComplet;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Admin(@NotNull(message = "le adminlogin ne doit pas etre null") String adminlogin, int active,
		@NotNull(message = "le password ne doit pas etre null") String password,
		@NotNull(message = "le nomComplet ne doit pas etre null") @Size(min = 4, max = 50) String nomComplet,
		@NotNull(message = "l adress ne doit pas etre null") String adress,
		@NotNull(message = "le numero de tel ne doit pas etre null") String telephone, Collection<Role> roles) {
	super();
	this.adminlogin = adminlogin;
	this.active = active;
	this.password = password;
	this.nomComplet = nomComplet;
	this.adress = adress;
	this.telephone = telephone;
	this.roles = roles;
}
public Admin() {
	super();
}




}
