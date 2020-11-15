package com.example.application.bean;

import org.springframework.stereotype.Component;

@Component
public class Reaction {
	private String type;
    private Utilisateur reactif;
	public Reaction() {
		super();
	}
	public Reaction(String type, Utilisateur reactif) {
		super();
		this.type = type;
		this.reactif = reactif;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Utilisateur getReactif() {
		return reactif;
	}
	public void setReactif(Utilisateur reactif) {
		this.reactif = reactif;
	}
    

}
