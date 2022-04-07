package com.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.auth.entities.Admin;
import com.auth.entities.Evaluation;
import com.auth.entities.Participant;
import com.auth.entities.Recommandation;
import com.auth.entities.Role;
import com.auth.entities.Sortie;
import com.auth.repositories.RecommandationRepository;
import com.auth.repositories.RoleRepository;
import com.auth.services.AdminService;
import com.auth.services.EvaluationService;
import com.auth.services.ParticipantService;
import com.auth.services.SortieService;


@SpringBootApplication
public class ProjetAutent3103Application implements CommandLineRunner {
	@Autowired
	RecommandationRepository recommandationRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	SortieService sortieService;
	@Autowired 
	AdminService adminService;
	@Autowired
	ParticipantService participantService;
	@Autowired
	EvaluationService evaluationService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetAutent3103Application.class, args);
	}
	
	//@Bean
	// avoir un BCryptEncoder qui est initialisÃ© une et une seule fois
	//public BCryptPasswordEncoder getBCPE()
	//{
		//return new BCryptPasswordEncoder();
		
	//}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// creer des utilisateurs avec des roles pour acceder
		
		Recommandation recommandation= new Recommandation("titrerecommanadation1", "text1", "01/04/2022");
		 recommandationRepository.save(recommandation);
		
		 
		 //addResponsabletoSortie(nom_complet,sortie)
		 //addResponsableToSortie(1,nomCompletguide)
		 Role role1=new Role("guide");
		 Role role2=new Role("organisateur");
		 roleRepository.save(role1);
		 roleRepository.save(role2);
		
		 /*
		  * 
		  * accountServiceImplement.saveUser(new User("admin", "monadmin",1, null));
		accountServiceImplement.saveRole(new Role("administrateur"));
		accountServiceImplement.addRoleToUser("admin", "administrateur");
		accountServiceImplement.saveUser(new User("user", "monuser",1, null));
		accountServiceImplement.saveRole(new Role("utilisateur"));
		accountServiceImplement.addRoleToUser("user", "utilisateur");
		
		 */
		 
		 adminService.saveAdmin(new Admin("AdminGuide", 1, "password1", "nomCompletAdminGuide", "adressadminguide1", "0749452671", null));
		 //admin.getNomComplet
		 adminService.addRoleToUser("AdminGuide", "guide");
		 adminService.saveAdmin(new Admin("adminorganisateur", 1, "password2", "nomCompletAdminorganisateur", "adressadmin1organisateur", "0749452671", null));
		 adminService.addRoleToUser("adminorganisateur", "organisateur");
	
		 Sortie sortie=new Sortie("titre","destination","depart","retour","description",150.10,null);
		 sortieService.saveSortie(sortie);
		 sortieService.addRespensableToSortie("nomCompletAdminGuide", sortie);
		 
		 
		Participant participant=new Participant("participant1nom", "participant1prenom", "participant1@gmail.com", "0745689231", 20, null);
		
		participantService.addSortieToParticipant(1,participant);
		participantService.addParticipant(participant);
		
		//evaluationService
		Evaluation evaluation1=new Evaluation("titreeval1", 4, "remarqueeval1", "nomeval1");
		evaluationService.addEvaluation(evaluation1);
		
		
		
		
	}

}
