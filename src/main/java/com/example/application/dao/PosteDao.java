package com.example.application.dao;


import java.util.List;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;


public interface PosteDao extends Neo4jRepository<Poste, Long> {
	 @Query("Match(n:Utilisateur {mail:$0})-[r]->(x:Poste)  RETURN  count(x)")
	 public Long getCountUtilisateuPoste(String mail);
}