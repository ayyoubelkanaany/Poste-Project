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
	private String etape;
    private String contenu;
    private String lien;
    private String categorie;
    private String datePoste;
    private String type;
    private List<Commentaire> commentaires;
    private List<Reaction> reactions;
    private String fichierNom;
	public Poste() {
		super();
	}
	public Poste(String contenu, String lien, String categorie, List<Commentaire> commentaires,
			List<Reaction> reactions) {
		super();
		this.contenu = contenu;
		this.lien = lien;
		this.categorie = categorie;
		this.commentaires = commentaires;
		this.reactions = reactions;
	}
	

	
	public String getEtape() {
		return etape;
	}
	public void setEtape(String etape) {
		this.etape = etape;
	}
	public String getFichierNom() {
		return fichierNom;
	}
	public void setFichierNom(String fichierNom) {
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
}
