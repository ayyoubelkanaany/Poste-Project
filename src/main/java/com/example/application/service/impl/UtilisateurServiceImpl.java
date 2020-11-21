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
	public List<Poste> getAllUserPoste(String idUtilisateur) {
		if(this.utilisateurDao.findById(idUtilisateur).isPresent()) {
			Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
			return u.getPostes();
		}
		return null;
	}
	@Override
	public List<Utilisateur> getByNom(String nom) {
		return utilisateurDao.findByNom(nom);
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
	public Utilisateur findById(String id) {
		
		return this.utilisateurDao.findById(id).get();
	}
	
    public List<Utilisateur> findAll() {
		return this.utilisateurDao.findAll();
	}
    
    //////////////////////////////////////////////////////////les postes
    
    @Override
    public Poste addPoste(Poste poste,String id) {
    Utilisateur u = this.utilisateurDao.findById(id).get();
	poste.setDatePoste(newDate());
	u.getPostes().add(poste);
	this.utilisateurDao.save(u);
	return poste;
    }
    
	@Transactional
    @Override
    public boolean deletePoste(String id, String datePoste) {
	Utilisateur u = this.utilisateurDao.findById(id).get();
	for(int i=0;i<u.getPostes().size();i++) {
		if(u.getPostes().get(i).getDatePoste().equals(datePoste)) {
			u.getPostes().remove(i);
			this.utilisateurDao.save(u);
			return true;
		}
	}
	return false;
}
@Override
public Poste updatePoste(String idUtilisateur, Poste poste) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		if(u.getPostes().get(i).getDatePoste().equals(poste.getDatePoste())){
			u.getPostes().get(i).setCategorie(poste.getCategorie());
			u.getPostes().get(i).setContenu(poste.getContenu());
			this.utilisateurDao.save(u);
			return u.getPostes().get(i);
		}
	}
	return null;
}

//////////////////////////////////////////////////////////les commentaires
@Override
public Commentaire addCommentaire(String idUtilisateur, String datePoste, Commentaire commentaire) {  
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		
		if(u.getPostes().get(i).getDatePoste().equals(datePoste)) {
			System.out.println("hello3");
			commentaire.setDateCommentaire(newDate());
			u.getPostes().get(i).getCommentaires().add(commentaire);
			this.utilisateurDao.save(u);
			return commentaire;
		}
	}
	return null;
}
@Transactional
@Override
public boolean deleteCommentaire(String idUtilisateur, String dateCommentaire) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		
		for(int j=0;j<u.getPostes().get(i).getCommentaires().size();j++) {
		
			if(u.getPostes().get(i).getCommentaires().get(j).getDateCommentaire().equals(dateCommentaire)) {
				
				u.getPostes().get(i).getCommentaires().remove(j);
				this.utilisateurDao.save(u);
				return true;
			}
			
		}
	}
	return false;
}
@Override
public Commentaire updateCommentaire(String idUtilisateur, String dateCommentaire, Commentaire commentaire) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		for(int j=0;j<u.getPostes().get(i).getCommentaires().size();j++) {
			if(u.getPostes().get(i).getCommentaires().get(j).getDateCommentaire().equals(dateCommentaire)) {
				u.getPostes().get(i).getCommentaires().get(j).setContenu(commentaire.getContenu());
				this.utilisateurDao.save(u);
				return u.getPostes().get(i).getCommentaires().get(j);
			}
			
		}
		
	}
	return null;
}

//////////////////////////////////////////////////////////les reactions
@Override
public Reaction addReaction(String idUtilisateur, String datePoste, Reaction reaction) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		if(u.getPostes().get(i).getDatePoste().equals(datePoste)){
			reaction.setDateReaction(newDate());
			u.getPostes().get(i).getReactions().add(reaction);
			this.utilisateurDao.save(u);
			return reaction;
		}
	}
	return null;
}
@Transactional
@Override
public boolean deleteReaction(String idUtilisateur, String dateReaction) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		for(int j=0;j<u.getPostes().get(i).getReactions().size();j++) {
			if(u.getPostes().get(i).getReactions().get(j).getDateReaction().equals(dateReaction)) {
				u.getPostes().get(i).getReactions().remove(j);
				this.utilisateurDao.save(u);
				return true;
			}
			
		}
	}
	return false;
}
@Override
public Reaction updateReaction(String idUtilisateur, String dateReaction, Reaction reaction) {
	Utilisateur u = this.utilisateurDao.findById(idUtilisateur).get();
	for(int i=0;i<u.getPostes().size();i++) {
		for(int j=0;j<u.getPostes().get(i).getReactions().size();j++) {
			if(u.getPostes().get(i).getReactions().get(j).getDateReaction().equals(dateReaction)) {
				u.getPostes().get(i).getReactions().get(j).setType(reaction.getType());
				this.utilisateurDao.save(u);
				return u.getPostes().get(i).getReactions().get(j);
			}
			
		}
		
	}
	return null;
}

private String newDate() {
	Date date = new Date();
	SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	String stringDate= DateFor.format(date);
	return stringDate;
}
}
