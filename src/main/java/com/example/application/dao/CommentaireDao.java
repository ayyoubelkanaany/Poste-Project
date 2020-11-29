package com.example.application.dao;


import java.util.List;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;


public interface CommentaireDao extends Neo4jRepository<Commentaire, Long> {
	
}