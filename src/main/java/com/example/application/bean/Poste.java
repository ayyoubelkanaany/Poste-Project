package com.example.application.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Poste implements Serializable {
	
    private String contenu;
    private String lien;
    private String categorie;
    private String datePoste;
    private String type;
    private String Etape;
    private List<Commentaire> commentaires;
    private List<Reaction> reactions;
    private  MultipartFile fichier ;
    private String fichierNom;
    
    
	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Poste(String contenu, String lien, String categorie, String datePoste, String type, String etape,
			List<Commentaire> commentaires, List<Reaction> reactions, MultipartFile fichier, String fichierNom) {
		super();
		this.contenu = contenu;
		this.lien = lien;
		this.categorie = categorie;
		this.datePoste = datePoste;
		this.type = type;
		Etape = etape;
		this.commentaires = commentaires;
		this.reactions = reactions;
		this.fichier = fichier;
		this.fichierNom = fichierNom;
	}

	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDatePoste() {
		return datePoste;
	}
	public void setDatePoste(String datePoste) {
		this.datePoste = datePoste;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtape() {
		return Etape;
	}
	public void setEtape(String etape) {
		Etape = etape;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public List<Reaction> getReactions() {
		return reactions;
	}
	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
	public MultipartFile getFichier() {
		return fichier;
	}
	public void setFichier(MultipartFile fichier) {
		this.fichier = fichier;
	}
	public String getFichierNom() {
		return fichierNom;
	}
	public void setFichierNom(String fichierNom) {
		this.fichierNom = fichierNom;
	}
	
}
