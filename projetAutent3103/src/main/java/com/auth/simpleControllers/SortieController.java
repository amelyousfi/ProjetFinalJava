package com.auth.simpleControllers;

import java.util.List;
import java.util.Optional;

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

import com.auth.entities.Sortie;

import com.auth.services.SortieService;
@RestController
public class SortieController {
	@Autowired
	SortieService sortieService;
	
@GetMapping("listeSorties")
public List<Sortie> showAll(){
	return sortieService.showSortie();

}
@PostMapping("addSortie/{nomComplet}")
public void addSortie(@Valid @RequestBody Sortie sortie, @PathVariable String nomComplet) {
	
	 sortieService.addRespensableToSortie(nomComplet,sortie);
	
}

@DeleteMapping("deleteSortie/{id}")
public void deleteSortie(@PathVariable int id) {
	sortieService.delelteSortie(id);
	
}
@GetMapping("searchSortieParTitre/{titre}")
public Optional<Sortie> findTitre(@PathVariable String titre){
	return sortieService.searchTitre(titre);
}
@GetMapping("searchParDestination/{destination}")
public Optional<Sortie> findDestination(@PathVariable String destination){
	return sortieService.searchDestination(destination);
}
@GetMapping("trouverParContenueDescription/{description}")
public Optional<Sortie> trouverParDescription(@PathVariable String description){
	return sortieService.findContenudescription(description);
}
@GetMapping("listeTriee")
public Page<Sortie> afficherListeTriee(Pageable pageable){
	return sortieService.findAllTrie(pageable);
}


}
