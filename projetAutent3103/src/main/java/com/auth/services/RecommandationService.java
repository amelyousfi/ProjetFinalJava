package com.auth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auth.entities.Recommandation;

import com.auth.repositories.RecommandationRepository;

@Service
public class RecommandationService {
	@Autowired
	RecommandationRepository  recommandationRepository; 
   public List<Recommandation> showAll(){
	   return recommandationRepository.findAll();
   }
	public  Recommandation createRecommandation( Recommandation  recommandation) {
		return recommandationRepository.save(recommandation);
	}
	public void deleteRecommandation(int id) {
		 recommandationRepository.deleteById(id);
	}
	
	public Page<Recommandation> findAllTrie(Pageable pageable){
		return recommandationRepository.findAll(pageable); 
	}
}
