package com.example.application.service.facad;

import java.util.List;

import com.example.application.bean.Commentaire;

public interface CommentaireService {
	///add,delete and update commentaire
	  public Commentaire addCommentaire(Long idPoste,Commentaire commentaire);
	  public boolean deleteCommentaire(Long idCommentaire);
	  public Commentaire updateCommentaire(Commentaire commentaire);
	  public Commentaire getById(Long idCommentaire);
}
