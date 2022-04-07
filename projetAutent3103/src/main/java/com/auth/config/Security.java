package com.auth.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception
	{
		//auth.inMemoryAuthentication().withUser("myadmin").password("{noop}admin").roles("Admininstrateur");
		
		//auth.inMemoryAuthentication().withUser("myuser").password("{noop}user").roles("utilisateur");
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery( // on verifie l'existance de l'Ã©lÃ©ment unique username (email cin, login)
				"select adminlogin as principal ,password, active as credentials from admin where adminlogin=?")
		.authoritiesByUsernameQuery( // on utilise le mÃªme paramÃ©tre pour rÃ©cupÃ©rer les roles
				"select admin_adminlogin as principal , roles_rolename as role from admin_roles "
						+ "where admin_adminlogin=?")
		.passwordEncoder(bCryptPasswordEncoder).rolePrefix("ROLE_"); // encoder le password
		// chercher le mdp => associer le mot ROLE_ comme prefix pour les roles rÃ©cupÃ©rer
		
		}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
	http.formLogin();
	http.csrf().disable();
	http.authorizeRequests().antMatchers("/login/**").permitAll();
	//http.authorizeRequests().antMatchers("/acceuil/**").permitAll();

	//http.authorizeRequests().antMatchers("/api/**").hasRole("administrateur");

	//autorisÃ© pour tout le monde
	http.authorizeRequests().antMatchers(HttpMethod.GET, "/acceuil").hasRole("guide");
	http.authorizeRequests().antMatchers(HttpMethod.GET, "/listeAdmin").hasRole("guide");
	http.authorizeRequests().antMatchers(HttpMethod.GET, "/listRole").hasRole("guide");
	http.authorizeRequests().antMatchers(HttpMethod.GET, "/listeSorties").hasRole("guide");
	
	
	
	
	//http.authorizeRequests().antMatchers(HttpMethod.POST, "/produit").hasRole("Admininstrateur");
	http.authorizeRequests().anyRequest().authenticated(); // le reste des requÃªtes est accessible uniquement si user=> authentificated
	}

		
}
