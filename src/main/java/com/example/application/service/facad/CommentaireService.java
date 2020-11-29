package com.example.application.service.facad;

import com.example.application.bean.Commentaire;

public interface CommentaireService {
	///add,delete and update commentaire
	  public Commentaire addCommentaire(Commentaire commentaire);
	  public boolean deleteCommentaire(Long id);
	  public Commentaire updateCommentaire(Commentaire commentaire);
	  public Commentaire getById(Long id);
}
