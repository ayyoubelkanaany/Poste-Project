package com.example.application.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
public class Poste implements Serializable {
    private String contenu;
    private String lien;  
    private String categorie;
    private List<Commentaire> commentaires;
    private List<Reaction> reactions;
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
