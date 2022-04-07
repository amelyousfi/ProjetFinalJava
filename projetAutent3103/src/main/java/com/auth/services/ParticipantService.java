package com.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entities.Participant;
import com.auth.entities.Sortie;
import com.auth.repositories.ParticipantRepo;
import com.auth.repositories.SortieRepository;



@Service
public class ParticipantService   {
@Autowired
ParticipantRepo participantrepo;
@Autowired
SortieRepository sortieRepository;
public void addSortieToParticipant(int id, Participant participant) {
	
	Sortie sortie=sortieRepository.findById(id).orElseThrow();
	participant.setSortie(sortie);
	participantrepo.save(participant);
	
	
	
}
	
	public List<Participant> findAll() {
		
		return participantrepo.findAll();
	}
	


	public Participant addParticipant(Participant participant) {
		return participantrepo.save(participant);
	}

	public Optional<Participant> findParticipantById(int id) {
		 return participantrepo.findById(id);
	}

	
	public void deleteParticipant(int id) {
		participantrepo.deleteById(id);
		
		
	}



}
