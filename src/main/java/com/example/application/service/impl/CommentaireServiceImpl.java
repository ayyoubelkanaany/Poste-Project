package com.example.application.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;
import com.example.application.dao.CommentaireDao;
import com.example.application.service.facad.CommentaireService;
import com.example.application.service.facad.PosteService;
import com.example.application.service.facad.UtilisateurService;
@Service
public class CommentaireServiceImpl implements CommentaireService{
	@Autowired
    private CommentaireDao commentaireDao;
	
	@Autowired
    private PosteService posteServiceImpl;
	@Autowired
    private UtilisateurService  utilisateurService;
	@Override
	public Commentaire addCommentaire(Long idPoste,Commentaire commentaire) {
		Poste loadedPoste = posteServiceImpl.getById(idPoste);
		Utilisateur loadedUtilisateur= utilisateurService.findById(commentaire.getCommentateur().getIdUtilisateur());
		commentaire.setCommentateur(loadedUtilisateur);
		commentaire.setDateCommentaire(newDate());
		loadedPoste.getCommentaires().add(commentaire);
	    this.posteServiceImpl.updatePoste(loadedPoste);
	   return commentaire;
	}

	@Override
	public boolean deleteCommentaire(Long idCommentaire) {
		try {
			this.commentaireDao.deleteById(idCommentaire);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Commentaire updateCommentaire(Commentaire commentaire) {
		Commentaire loadedCommentaire = commentaireDao.findById(commentaire.getIdCommentaire()).get();
		loadedCommentaire.setContenu(commentaire.getContenu());
		return this.commentaireDao.save(loadedCommentaire);
	}

	@Override
	public Commentaire getById(Long idCommentaire) {
		
		if(commentaireDao.findById(idCommentaire).isPresent()) {
			
			return this.commentaireDao.findById(idCommentaire).get();
		}
		return null;
		
	}

private String newDate() {
	Date date = new Date();
	SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String stringDate= DateFor.format(date);
	return stringDate;
}

}
