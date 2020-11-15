package com.example.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.bean.Utilisateur;
import com.example.application.dao.UtilisateurDao;
import com.example.application.service.facad.UtilisateurService;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
    private UtilisateurDao utilisateurDao;
	@Override
	public List<Utilisateur> getByNom(String nom) {
		return utilisateurDao.findByNom(nom);
	}
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return this.utilisateurDao.save(utilisateur);
	}
	@Override
	public Utilisateur findById(String id) {
		
		return this.utilisateurDao.findById(id).get();
	}
	
public List<Utilisateur> findAll() {
		return this.utilisateurDao.findAll();
	}

}
