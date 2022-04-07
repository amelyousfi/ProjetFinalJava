package com.auth.simpleControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entities.Participant;

import com.auth.services.ParticipantService;

@RestController

public class ParticipantController {
	@Autowired
	ParticipantService participantService;
	
	@GetMapping("listeParticipants")
	public List<Participant> showAll(){
		return participantService.findAll();

	}
	
	@PostMapping("addParticipant/{id}")
	public void addParticipant(@PathVariable int  id,@Valid @RequestBody Participant participant) {
		participantService.addSortieToParticipant(id, participant);
	}
	
	@DeleteMapping("deleteParticipant/{id}")
	public void deleteSortie(@PathVariable int id) {
		participantService.deleteParticipant(id);
		
	}
	
	
	/*
	 * @PostMapping("addSortie/{nomComplet}")
public void addSortie(@Valid @RequestBody Sortie sortie, @PathVariable String nomComplet) {
	
	 sortieService.addRespensableToSortie(nomComplet,sortie);
	
}
	 */
}
