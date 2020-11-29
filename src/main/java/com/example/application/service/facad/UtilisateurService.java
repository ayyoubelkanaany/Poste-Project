package com.example.application.service.facad;

import java.util.List;
import com.example.application.bean.Commentaire;
import com.example.application.bean.Poste;
import com.example.application.bean.Reaction;
import com.example.application.bean.Utilisateur;

public interface UtilisateurService {
  public List<Utilisateur> getByNom(String nom);
  public List<Utilisateur> getByPostesCategorie(String categorie);
  public List<Utilisateur> getByPostesDatePoste(String datePoste);
  public List<Utilisateur> getUtilisateurByOrderByCountByPostesAsc();
  public Utilisateur save(Utilisateur utilisateur);
  public Utilisateur findById(Long id);
  public Utilisateur findByMail(String mail);
  //delete,add and update poste
  public Poste addPoste(Poste poste,Long id);
  public boolean deletePoste(Long id,String datePoste);
  public Poste updatePoste(Long idUtilisateur,Poste poste);
  
  ///add,delete and update commentaire
  public Commentaire addCommentaire(Long idUtilisateur,String datePoste,Commentaire commentaire);
  public boolean deleteCommentaire(Long idUtilisateur,String dateCommentaire);
  public Commentaire updateCommentaire(Long idUtilisateur,String dateCommentaire,Commentaire commentaire);
  
///add,delete and update Reaction
  public Reaction addReaction(Long idUtilisateur,String datePoste,Reaction reaction);
  public boolean deleteReaction(Long idUtilisateur,String dateReaction);
  public Reaction updateReaction(Long idUtilisateur,String dateReaction,Reaction reaction);
  ///get all user postes
  public List<Poste> getAllUserPoste(Long idUtilisateur);
  
 //
  public int countRactionsLike(Long idUtilisateur,String datePoste);
  public int countRactionsDislike(Long idUtilisateur,String datePoste);
  public int countCommentaires(Long idUtilisateur,String datePoste);
  
}
