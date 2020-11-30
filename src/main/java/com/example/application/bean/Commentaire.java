package com.example.application.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Node
public class Commentaire implements Serializable{
    @Id@GeneratedValue
	private Long idCommentaire;
	private String contenu;
	@Relationship(type = "commenter" ,direction = Direction.OUTGOING)
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
	
	
	

	public Long getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
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
