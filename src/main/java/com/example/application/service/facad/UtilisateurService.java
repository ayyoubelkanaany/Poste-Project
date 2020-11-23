package com.example.application.service.facad;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;

public interface UtilisateurService {
  public List<Utilisateur> getByNom(String nom);
  public Utilisateur save(Utilisateur utilisateur);
  public Utilisateur findById(String id);
  
  //delete,add and update poste
  public Poste addPoste(Poste poste,String id);
  public boolean deletePoste(String id,String datePoste);
  public Poste updatePoste(String idUtilisateur,Poste poste);
  
  ///add,delete and update commentaire
  public Commentaire addCommentaire(String idUtilisateur,String datePoste,Commentaire commentaire);
  public boolean deleteCommentaire(String idUtilisateur,String dateCommentaire);
  public Commentaire updateCommentaire(String idUtilisateur,String dateCommentaire,Commentaire commentaire);
  
///add,delete and update Reaction
  public Reaction addReaction(String idUtilisateur,String datePoste,Reaction reaction);
  public boolean deleteReaction(String idUtilisateur,String dateReaction);
  public Reaction updateReaction(String idUtilisateur,String dateReaction,Reaction reaction);
  ///get all user postes
  public List<Poste> getAllUserPoste(String idUtilisateur);
  
 //
  public int countRactionsLike(String idUtilisateur,String datePoste);
  public int countRactionsDislike(String idUtilisateur,String datePoste);
  public int countCommentaires(String idUtilisateur,String datePoste);
  
}
