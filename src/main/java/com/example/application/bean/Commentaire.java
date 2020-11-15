package com.example.application.bean;

import org.springframework.stereotype.Component;

@Component
public class Commentaire {
	private String contenu;
    private Utilisateur commentateur;
    
	public Commentaire() {
		super();
	}
	
	public Commentaire(String contenu, Utilisateur commentateur) {
		super();
		this.contenu = contenu;
		this.commentateur = commentateur;
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
