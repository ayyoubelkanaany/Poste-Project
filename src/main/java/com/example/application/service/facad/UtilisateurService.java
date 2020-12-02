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
  public Utilisateur findById(Long idUtilisateur);
  public Utilisateur findByMail(String mail);
  
}
