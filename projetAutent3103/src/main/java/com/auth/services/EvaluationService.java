package com.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entities.Evaluation;
import com.auth.repositories.EvaluationRepo;


@Service
public class EvaluationService  {
	@Autowired
	EvaluationRepo evaluationRepo;

	public List<Evaluation> findAll() {
		return evaluationRepo.findAll();
	}


	public Evaluation addEvaluation(Evaluation evaluation) {
		return evaluationRepo.save(evaluation);
	}

	
	public Optional<Evaluation> findEvaluationById(int id) {
		return evaluationRepo.findById(id);
	}

	
	public void deleteEvaluation(int id) {
		evaluationRepo.deleteById(id);
		
	}

}
