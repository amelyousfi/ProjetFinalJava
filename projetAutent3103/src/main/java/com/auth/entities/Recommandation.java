package com.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Recommandation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="le titre ne doit pas etre null")
	private String titre;
	@NotNull(message="le text ne doit pas etre null")
	private String texte;
	@NotNull(message="la date  ne doit pas etre null")
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Recommandation(int id, @NotNull(message = "le titre ne doit pas etre null") String titre,
			@NotNull(message = "le text ne doit pas etre null") String texte,
			@NotNull(message = "la date  ne doit pas etre null") String date) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.date = date;
	}
	public Recommandation() {
		super();
	}
	public Recommandation(@NotNull(message = "le titre ne doit pas etre null") String titre,
			@NotNull(message = "le text ne doit pas etre null") String texte,
			@NotNull(message = "la date  ne doit pas etre null") String date) {
		super();
		this.titre = titre;
		this.texte = texte;
		this.date = date;
	}
	
	

}
