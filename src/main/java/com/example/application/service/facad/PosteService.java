package com.example.application.service.facad;

import java.util.List;

import com.example.application.bean.Poste;
import com.example.application.bean.Utilisateur;

public interface PosteService {
	//delete,add and update poste
	  public Poste getById(Long idPoste);
	  public Poste addPoste(Poste poste);
	  public boolean deletePoste(Long idPoste);
	  public Poste updatePoste(Poste poste);
	  public List<Poste> getAllPoste();
	  //
	  public int countRactionsLike(Long idPoste);
	  public int countRactionsDislike(Long idPoste);
	  public int countCommentaires(Long idPoste);
	  public List<Utilisateur> getUtilisateursActive();
	  public List<Poste> findByCategorie(String categorie);
	  public List<Poste> findByPosteurMail(String mail);
}
