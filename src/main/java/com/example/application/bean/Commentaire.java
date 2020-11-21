package com.example.application.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Commentaire {
	private String contenu;
    private Utilisateur commentateur;
    private String dateCommentaire;
    
	public Commentaire() {
		super();
	}
	
	public Commentaire(String contenu, Utilisateur commentateur) {
		super();
		this.contenu = contenu;
		this.commentateur = commentateur;
	}

	

	public String getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(String dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Utilisateur getCommentateur() {
		return commentateur;
	}
	public void setCommentateur(Utilisateur commentateur) {
		this.commentateur = commentateur;
	}
    
}
