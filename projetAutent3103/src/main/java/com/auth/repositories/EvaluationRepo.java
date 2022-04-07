package com.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.Evaluation;



public interface EvaluationRepo extends JpaRepository<Evaluation, Integer> {

}
