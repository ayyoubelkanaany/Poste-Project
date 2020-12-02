package com.example.application.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;
import com.example.application.dao.PosteDao;
import com.example.application.service.facad.CommentaireService;
import com.example.application.service.facad.PosteService;
import com.example.application.service.facad.ReactionService;
import com.example.application.service.facad.UtilisateurService;
@Service
public class PosteServiceImpl implements PosteService{
	@Autowired
    private PosteDao posteDao;
	@Autowired
	private CommentaireService CommentaireServiceImpl;
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	@Autowired
	private ReactionService reactionServiceImpl;
    //////////////////////////////////////////////////////////les postes
    
	@Override
	public Poste getById(Long id) {
		return this.posteDao.findById(id).get();
	}
	@Override
	public Poste addPoste(Poste poste) {
		Utilisateur loadedUtilisateur = this.utilisateurServiceImpl.findById(poste.getPosteur().getIdUtilisateur());
		poste.setPosteur(loadedUtilisateur);
		poste.setDatePoste(newDate());
		return this.posteDao.save(poste);
	}
	@Override
	public boolean deletePoste(Long idPoste) {
		Poste loadedPoste;
		if( posteDao.findById(idPoste).isPresent()) {
		loadedPoste = posteDao.findById(idPoste).get();
		for(int i = 0; i <loadedPoste.getCommentaires().size();i++) {
			this.CommentaireServiceImpl.deleteCommentaire(loadedPoste.getCommentaires().get(i).getIdCommentaire());
		}
		for(int i = 0; i <loadedPoste.getReactions().size();i++) {
			this.reactionServiceImpl.deleteReaction(loadedPoste.getReactions().get(i).getIdReaction());
		}
		this.posteDao.deleteById(idPoste);
		return true;
		}
		return false;
	}
	@Override
	public Poste updatePoste(Poste poste) {
		return this.posteDao.save(poste);
	}
	@Override
	public List<Poste> getAllPoste() {
		return this.posteDao.findAll();
	}
	@Override
	public int countRactionsLike(Long id) {
		int  count = 0;
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		List<Reaction> loadedReactions = loadedPosteDao.getReactions();
			for(int i =0;i<loadedReactions.size();i++) {
				if(loadedReactions.get(i).getType().equals("like")) {
				count++;
			}
		}
		return count;
	}
	@Override
	public int countRactionsDislike(Long id) {
		int  count = 0;
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		List<Reaction> loadedReactions = loadedPosteDao.getReactions();
			for(int i =0;i<loadedReactions.size();i++) {
				if(loadedReactions.get(i).getType().equals("dislike")) {
				count++;
			}
		}
		return count;
	}
	@Override
	public int countCommentaires(Long id) {
		Poste loadedPosteDao = this.posteDao.findById(id).get();
		return loadedPosteDao.getCommentaires().size();
	}
	private String newDate() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String stringDate= DateFor.format(date);
		return stringDate;
	}
	public List<Poste> findByCategorie(String categorie){
		return this.posteDao.findByCategorie(categorie);
	}
	
	public List<Poste> findByPosteurMail(String mail){
		return this.posteDao.findByPosteurMail(mail);
	}
	@Override
	public List<Utilisateur> getUtilisateursActive() {
		List<Utilisateur> returnedUtilisateur= new ArrayList<Utilisateur>();
	    List<Utilisateur> loadedUtilisateur= utilisateurServiceImpl.findAll();
	  
		   for (int i = 10;i>0;i--) {
			   for(int j=0;j<loadedUtilisateur.size();j++) {
			     if(this.posteDao.getCountUtilisateuPoste(loadedUtilisateur.get(j).getMail())>i) {
			    	 if(returnedUtilisateur.size()==0) {
			    		 returnedUtilisateur.add(loadedUtilisateur.get(j));
			    	 }
			    	 else {
			    		 
			    	 for (int j2 = 0; j2 < returnedUtilisateur.size(); j2++) {
			    		 if(loadedUtilisateur.get(j).getMail()==returnedUtilisateur.get(j2).getMail()) {
			    			 
			    		 }
			    		 else {
			    			 returnedUtilisateur.add(loadedUtilisateur.get(j));
			    		 }
						
					}
			    	 }
			    	 
			  }
			}
		}
		System.out.println(returnedUtilisateur.size());
		return returnedUtilisateur;
	}
}