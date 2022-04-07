package com.auth.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.auth.entities.Sortie;

public interface SortieRepository extends JpaRepository<Sortie, Integer> {
   // public Sortie findById(int id);
	public  Optional<Sortie> findByTitre(String titre);
	public Optional<Sortie> findByDestination(String destination); 
	public Optional<Sortie> findByDescriptionContaining(String description); 
	public Page<Sortie> findAll(Pageable pageable);
	

}
