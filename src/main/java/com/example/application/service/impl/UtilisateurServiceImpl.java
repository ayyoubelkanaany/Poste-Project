package com.example.application.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;
import com.example.application.dao.UtilisateurDao;
import com.example.application.service.facad.UtilisateurService;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
    private UtilisateurDao utilisateurDao;
	@Autowired
	private FileStorageServiceImpl fileStorageService;
   ////////////////////////////////////////utilisateur
	
	@Override
	public List<Utilisateur> getByNom(String nom) {
		return utilisateurDao.findByNom(nom);
	}
	@Override
	public List<Utilisateur> getByPostesCategorie(String categorie) {
		return utilisateurDao.findByPostesCategorie(categorie);
	}
	@Override
	public List<Utilisateur> getByPostesDatePoste(String datePoste) {
		return utilisateurDao.findByPostesDatePoste(datePoste);
	}
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		for (Utilisateur utilisateur1 : utilisateurs) {
			if(utilisateur1.getMail().equals(utilisateur.getMail())) {
				return null;
			}
		}
		return this.utilisateurDao.save(utilisateur);
	}
	@Override
	public Utilisateur findById(Long id) {
		
		return this.utilisateurDao.findById(id).get();
	}
	@Override
	public Utilisateur findByMail(String mail) {
		
		return this.utilisateurDao.findByMail(mail);
	}
    public List<Utilisateur> findAll() {
		return this.utilisateurDao.findAll();
	}
    
    



private String newDate() {
	Date date = new Date();
	SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	String stringDate= DateFor.format(date);
	return stringDate;
}

//get users orederby postes
@Override
public List<Utilisateur> getUtilisateurByOrderByCountByPostesAsc() {
	// TODO Auto-generated method stub
	return utilisateurDao.findByOrderByPostesDesc();
}

}
