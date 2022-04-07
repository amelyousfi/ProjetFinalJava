package com.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;


@Entity
public class Evaluation {
	// id titre note remarque nom
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="le titre ne doit pas etre null")
	private String titre;
	@NotNull(message="lnote  ne doit pas etre null")
	
	private int note;
	@NotNull(message="la remarque  ne doit pas etre null")
	@Lob
	private String remarque;
	
	@NotNull(message="le titre ne doit pas etre null")
	private String nom;

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

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public Evaluation() {
		super();
	}

	public Evaluation(int id, @NotNull(message = "le titre ne doit pas etre null") String titre,
			@NotNull(message = "lnote  ne doit pas etre null") int note,
			@NotNull(message = "la remarque  ne doit pas etre null") String remarque,
			@NotNull(message = "le titre ne doit pas etre null") String nom) {
		super();
		this.id = id;
		this.titre = titre;
		this.note = note;
		this.remarque = remarque;
		this.nom = nom;
	}

	public Evaluation(@NotNull(message = "le titre ne doit pas etre null") String titre,
			@NotNull(message = "lnote  ne doit pas etre null") int note,
			@NotNull(message = "la remarque  ne doit pas etre null") String remarque,
			@NotNull(message = "le titre ne doit pas etre null") String nom) {
		super();
		this.titre = titre;
		this.note = note;
		this.remarque = remarque;
		this.nom = nom;
	}


	
	
	
	
	
}
