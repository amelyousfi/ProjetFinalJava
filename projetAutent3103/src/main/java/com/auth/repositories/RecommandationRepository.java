package com.auth.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.Recommandation;


public interface RecommandationRepository extends JpaRepository<Recommandation, Integer> {
	public Page<Recommandation> findAll(Pageable pageable);

}
