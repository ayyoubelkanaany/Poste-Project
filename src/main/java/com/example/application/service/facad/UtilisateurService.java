package com.example.application.service.facad;

import java.util.List;

import com.example.application.bean.Utilisateur;

public interface UtilisateurService {
  public List<Utilisateur> getByNom(String nom);
  public Utilisateur save(Utilisateur utilisateur);
  public Utilisateur findById(String id);
}
