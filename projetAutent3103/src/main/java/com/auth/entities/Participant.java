package com.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="le nom ne doit pas etre null")
	private String nom;
	@NotNull(message="le prenom ne doit pas etre null")
	private String prenom;
	@NotNull(message="leemail ne doit pas etre null")
	private String email;
	@NotNull(message="le tel ne doit pas etre null")
	private String telephone;
	@NotNull(message="l age ne doit pas etre null")
	@Min(16)
	private int age;
	@ManyToOne(optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	@JoinColumn(name = "id_sortie", referencedColumnName = "id")
	private Sortie sortie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public Sortie getSortie() {
		return sortie;
	}
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
	public Participant(int id, @NotNull(message = "le nom ne doit pas etre null") String nom,
			@NotNull(message = "le prenom ne doit pas etre null") String prenom,
			@NotNull(message = "leemail ne doit pas etre null") String email,
			@NotNull(message = "le tel ne doit pas etre null") String telephone,
			@NotNull(message = "l age ne doit pas etre null") @Min(16) int age, Sortie sortie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.sortie = sortie;
	}
	public Participant() {
		super();
	}
	public Participant(@NotNull(message = "le nom ne doit pas etre null") String nom,
			@NotNull(message = "le prenom ne doit pas etre null") String prenom,
			@NotNull(message = "leemail ne doit pas etre null") String email,
			@NotNull(message = "le tel ne doit pas etre null") String telephone,
			@NotNull(message = "l age ne doit pas etre null") @Min(16) int age, Sortie sortie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.sortie = sortie;
	}
	


	
}
