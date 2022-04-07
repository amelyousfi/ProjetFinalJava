package com.auth.modelControlers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EvaluationMController {
	@GetMapping("")
	public String acceuil() {
		return "acceuil";
	}
	@GetMapping("recommendation")
	public String afficherPageGestion() {
		return "gestionRecommandation";
	}
}
