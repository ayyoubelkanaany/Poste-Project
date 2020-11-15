package com.example.application.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document("Utilisateur")
public class Utilisateur implements Serializable {
	//coucou les amis test
	@Id
	private String id_Utilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	private String telephone;
	private String universite;
    private String niveau;
    private String entreprise;
    private List<Poste> postes;
	
	public Utilisateur() {
		super();
	}
	

	public Utilisateur(String nom, String prenom, String mail, String password, String telephone, String universite,
			String niveau, String entreprise) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.telephone = telephone;
		this.universite = universite;
		this.niveau = niveau;
		this.entreprise = entreprise;
	}


	public String getId_Utilisateur() {
		return id_Utilisateur;
	}


	public void setId_Utilisateur(String id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}


	public List<Poste> getPostes() {
		return postes;
	}


	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
}
