package com.example.application.dao;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;


public interface UtilisateurDao extends Neo4jRepository<Utilisateur, Long> {
	public List<Utilisateur> findByNom(String nom);
	public Utilisateur findByMail(String mail);
	public List<Utilisateur> findByPostesCategorie(String categorie);
	public List<Utilisateur> findByPostesDatePoste(String datePoste);
	public List<Utilisateur> findByOrderByPostesDesc();
}