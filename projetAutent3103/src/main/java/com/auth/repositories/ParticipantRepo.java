package com.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.Participant;


public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

}
