package com.example.application.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;
import com.example.application.dao.ReactionDao;
import com.example.application.service.facad.PosteService;
import com.example.application.service.facad.ReactionService;
import com.example.application.service.facad.UtilisateurService;
@Service
public class ReactionServiceImpl implements ReactionService {
	
	@Autowired
	private ReactionDao reactionDao;
    
    @Autowired
    private PosteService posteServiceImpl;
    @Autowired
    private UtilisateurService  utilisateurService;
    
    
	@Override
	public Reaction addReaction(Long idPoste,Reaction reaction) {
		Poste loadedPoste = posteServiceImpl.getById(idPoste);
		Utilisateur loadedUtilisateur = utilisateurService.findById(reaction.getReactif().getIdUtilisateur());
		reaction.setReactif(loadedUtilisateur);
		reaction.setDateReaction(newDate());
		loadedPoste.getReactions().add(reaction);
	    this.posteServiceImpl.updatePoste(loadedPoste);
		return reaction;
	}
	@Override
	public boolean deleteReaction(Long idReaction) {
		try {
			this.reactionDao.deleteById(idReaction);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Reaction updateReaction(Reaction reaction) {
		Reaction loadedReaction = this.reactionDao.findById(reaction.getIdReaction()).get();
		loadedReaction.setType(reaction.getType());
		return this.reactionDao.save(loadedReaction);
	}

	@Override
	public Reaction getByReactionId(Long idReaction) {
		
		return this.reactionDao.findById(idReaction).get();
	}
	private String newDate() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String stringDate= DateFor.format(date);
		return stringDate;
	}
	
}
