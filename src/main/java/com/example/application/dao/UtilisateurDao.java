package com.example.application.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;
import com.mongodb.internal.operation.FindAndDeleteOperation;
@Repository
public interface UtilisateurDao extends MongoRepository<Utilisateur, String> {
	public List<Utilisateur> findByNom(String nom);
}