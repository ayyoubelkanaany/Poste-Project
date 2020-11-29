package com.example.application.service.facad;

import java.util.List;

import com.example.application.bean.Poste;

public interface PosteService {
	//delete,add and update poste
	  public Poste getById(Long id);
	  public Poste addPoste(Poste poste);
	  public boolean deletePoste(Long id);
	  public Poste updatePoste(Poste poste);
	  public List<Poste> getAllPoste();
	  //
	  public int countRactionsLike(Long id);
	  public int countRactionsDislike(Long id);
	  public int countCommentaires(Long id);
}
