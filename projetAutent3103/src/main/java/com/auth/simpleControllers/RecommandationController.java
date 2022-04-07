package com.auth.simpleControllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import com.auth.entities.Sortie;
import com.auth.services.SortieService;
*/

import com.auth.entities.Recommandation;

import com.auth.services.RecommandationService;

@RestController
public class RecommandationController {
	@Autowired
	RecommandationService recoService;
	
	@GetMapping("listeRecommandation")
	public List<Recommandation> showRecListe(){
		return recoService.showAll();
	}
	@PostMapping("ajouterRecommandation")
	public Recommandation ajouterRecommandation(@Valid @RequestBody Recommandation recommandation) {
		return recoService.createRecommandation(recommandation);
	}
	@DeleteMapping("supprimerRecommandation/{id}")
	public void supprimerRecommandation(@PathVariable int id) {
		recoService.deleteRecommandation(id);
	}
	@GetMapping("listeTrieeRecommandation")
	public Page<Recommandation> afficherListeTrieeRecommandation(Pageable pageable){
		return recoService.findAllTrie(pageable);
	}

	
}


