package com.example.application.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Node
public class Poste implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String etape;
    private String contenu;
    private String lien;
    private String categorie;
    private String datePoste;
    private String type;
    @Relationship(type = "poster",direction = Direction.INCOMING)
    private Utilisateur posteur;
    @Relationship(type = "concerne",direction = Direction.INCOMING)
    private List<Commentaire> commentaires;
    @Relationship(type = "concerne",direction = Direction.INCOMING)
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
	
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
