package com.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auth.entities.Admin;

import com.auth.entities.Sortie;
import com.auth.repositories.AdminRepository;
import com.auth.repositories.SortieRepository;

@Service
public class SortieService {
	@Autowired
	SortieRepository sortieRepo;
	@Autowired
	AdminRepository adminRepo;
	
	public List<Sortie> showSortie(){
		return sortieRepo.findAll();
		
	}
	public Sortie saveSortie(Sortie sortie) {
		return sortieRepo.save(sortie);
	}
	public void delelteSortie(int  id) {
		sortieRepo.deleteById(id);
		
	}
	
	public Optional<Sortie> searchTitre(String titre ){
		return sortieRepo.findByTitre(titre);
	}
	public Optional<Sortie> searchDestination(String destination){
		return sortieRepo.findByDestination(destination);
		
	}
	public Optional<Sortie> findContenudescription(String description){
		return sortieRepo.findByDescriptionContaining(description);
		
	}
	public Page<Sortie> findAllTrie(Pageable pageable){
		return sortieRepo.findAll(pageable); 
	}
	public void addRespensableToSortie(String nomComplet,Sortie sortie)
	{
		
		Admin admin=adminRepo.findByNomComplet(nomComplet);
		sortie.setAdmin(admin);
		saveSortie(sortie);
		
		
	}
	

}
